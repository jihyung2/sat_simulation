from pyevsim import BehaviorModelExecutor, SystemSimulator, Infinite
import datetime
import time
import pymysql
import sys
import socket
import json

import requests
import random
import gspread
from oauth2client.service_account import ServiceAccountCredentials
import logging
from os import path
from PIL import Image
import base64
sys.path.append(path.dirname( path.dirname( path.abspath(__file__) ) ))

n=0

class PEx(BehaviorModelExecutor):

    def __init__(self, instance_time, destruct_time, name, engine_name):
        BehaviorModelExecutor.__init__(self, instance_time, destruct_time, name,
                                       engine_name)
        self.init_state("Wait")
        self.insert_state("Wait", Infinite)
        # self.insert_state("Generate", 1)
        self.insert_state("Satsimulation_Start", 1)
        self.insert_state("Temperature", 1)
        self.insert_state("Pressure", 1)
        self.insert_state("Humidity", 1)
        self.insert_state("Dust", 1)
        self.insert_input_port("start")

        # self.custom_date = ''

    def ext_trans(self, port, msg):
        if port == "start":
            # print(f"[app started]")
            # print("Date input : ")
            # date_ = input()
            # self.set_date(date_)
            self._cur_state = "Satsimulation_Start"

    def output(self):
        self.index = 0
        self.item_list = []
        print("==========================")
        for i in range(len(self.menu)):
            self._cur_state, self.temp = self.int_trans()
            self.item_list.append(int(self.temp))
            self.index += 1

        print(self.item_list)
        self.put_db(self.item_list)
        self.item_list = []
        time.sleep(5)
        self.index = 0
        return None

    def put_db(self, item_list):
        pass

    def int_trans(self):
        now = datetime.datetime.now()
        global n

        if self.menu[self.index] == "Temperature":
            def sync_webhook_send(request_data):
                now = datetime.datetime.now()
                webhook_url = f"http://127.0.0.1:5000/sensor"
                webhook_data = {"satname":"000000000000000001","sensorname": "Temperature", "value": request_data}

                try:
                    response = requests.post(webhook_url, json=webhook_data)
                    if response.status_code == 200:
                        print("성공")
                    else:
                        print("실패")
                except Exception as e:
                    print(f"웹훅 요청 중 오류 발생: {e}")

            sync_webhook_send(random.randint(1, 100))

            return self.menu[self.index], 0

        if self.menu[self.index] == "Pressure":
            def sync_webhook_send(request_data):
                now = datetime.datetime.now()
                webhook_url = f"http://127.0.0.1:5000/sensor"
                webhook_data = {"satname":"000000000000000001","sensorname": "Pressure", "value": request_data}

                try:
                    response = requests.post(webhook_url, json=webhook_data)
                    if response.status_code == 200:
                        print("성공")
                    else:
                        print("실패")
                except Exception as e:
                    print(f"웹훅 요청 중 오류 발생: {e}")

            sync_webhook_send(random.randint(1, 100))

            return self.menu[self.index], 0

        if self.menu[self.index] == "Humidity":
            def sync_webhook_send(request_data):
                now = datetime.datetime.now()
                webhook_url = f"http://127.0.0.1:5000/sensor"
                webhook_data = {"satname":"000000000000000001","sensorname": "Humidity", "value": request_data}

                try:
                    response = requests.post(webhook_url, json=webhook_data)
                    if response.status_code == 200:
                        print("성공")
                    else:
                        print("실패")
                except Exception as e:
                    print(f"웹훅 요청 중 오류 발생: {e}")

            sync_webhook_send(random.randint(1, 100))

            return self.menu[self.index], 0

        if self.menu[self.index] == "Dust":
            def sync_webhook_send(request_data):
                now = datetime.datetime.now()
                webhook_url = f"http://127.0.0.1:5000/sensor"
                webhook_data = {"satname": "000000000000000001", "sensorname": "Dust", "value": request_data}

                try:
                    response = requests.post(webhook_url, json=webhook_data)
                    if response.status_code == 200:
                        print("성공")
                    else:
                        print("실패")
                except Exception as e:
                    print(f"웹훅 요청 중 오류 발생: {e}")

            sync_webhook_send(random.randint(1, 100))

            return self.menu[self.index], 0


    def insert_list(self, arr):
        setattr(self, "menu", arr)
        setattr(self, "index", 0)
        setattr(self, "temp", 0)


def start():
    print("pyevsim_Auto_UpdateServer Start...")
    menu = ['Temperature', 'Pressure', 'Humidity', 'Dust']
    ss = SystemSimulator()
    ss.register_engine("first", "REAL_TIME", 1)
    ss.get_engine("first").insert_input_port("start")
    gen = PEx(0, Infinite, "Gen", "first")
    gen.insert_list(menu)
    ss.get_engine("first").register_entity(gen)
    ss.get_engine("first").coupling_relation(None, "start", gen, "start")
    ss.get_engine("first").insert_external_event("start", None)
    ss.get_engine("first").simulate()


start()