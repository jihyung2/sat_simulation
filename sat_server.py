from flask import Flask, request, jsonify
import datetime
import can
import json
import serial

app = Flask(__name__)

# sensor_rule.json 파일에서 센서 이름과 sensorID 매핑 정보를 읽어옵니다.
with open('sensor_rule.json') as json_file:
    sensor_rules = json.load(json_file)

# 센서 이름을 표준 ID로 매핑 (sensorID를 정수로 변환)
sensor_id_mapping = {rule['sensorType']: int(rule['sensorID'], 2) for rule in sensor_rules}

# 시리얼 통신을 위한 설정
ser = serial.Serial("COM3", 9600)

@app.route('/sensor', methods=['POST'])
def sensor():
    data = request.get_json()  # 웹훅 요청으로부터 데이터를 받아옵니다.
    print(f"데이터 수신 시간: {datetime.datetime.now()}")
    print(f"수신한 데이터: {data}")

    # 센서 이름을 표준 ID로 변환
    sensor_name = data.get('sensorname')
    sensor_id = sensor_id_mapping.get(sensor_name, 0)
    print(f"센서 ID: {sensor_id}")

    # satname을 확장 ID로 변환
    satname = data.get('satname')
    sat_id = int(satname, 2) if satname else 0
    print(f"위성 ID: {sat_id}")


    # 여기서는 센서 ID를 11비트로, 위성 ID를 나머지 18비트로 제한합니다.
    arbitration_id = (sensor_id << 18) | sat_id
    arbitration_id_bin = format(arbitration_id, '029b')
    print(f"전송 ID (비트): {arbitration_id_bin}")

    # CAN 데이터 프레임으로 변환합니다.
    # 확장 ID에 센서 종류와 위성 값을 넣습니다.
    data_bytes = (data['value']).to_bytes((data['value'].bit_length() + 7) // 8, 'big')
    message = can.Message(arbitration_id=arbitration_id, data=data_bytes, is_extended_id=True)  # CAN 메시지를 생성합니다.

    message_bits = ''.join(format(byte, '08b') for byte in message.data)

    print(f"CAN 메시지 비트 배열: {message_bits}")

    # CAN 메시지를 문자열로 변환하여 출력합니다.
    message_str = str(message)
    print(f"CAN 메시지: {message_str}")

    message_bytes = ' '.join(format(byte, '08b') for byte in message.data)
    print(f"CAN 메시지 바이트 배열: {message_bytes}")

    message_bytes = message_bytes.replace(' ', '')

    # 시리얼 통신으로 메시지를 전송합니다.
    # 데이터 시작과 끝, 그리고 데이터 간 구분을 위한 문자를 추가합니다.
    ser.write(('@'+arbitration_id_bin+message_bytes+'&').encode('utf-8'))  # 메시지 데이터
    print(('@'+arbitration_id_bin+message_bytes+'&').encode('utf-8'))

    return jsonify({'message': '수신 성공'}), 200

if __name__ == '__main__':
    app.run(host='127.0.0.1', port=8050)
