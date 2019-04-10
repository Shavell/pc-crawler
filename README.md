## PC Crawler Application

This application created for local requirements. 


**Application development not completed!**


## Todo

- [ ] Documentation
- [ ] JavaDoc Documentation
- [ ] Code Cleaning
- [ ] React Listing Frontend
- [ ] Gui Application Get Server Ip with Parameter
- [ ] Multilang (turkish only now)
- [x] Heroku Implementation
- [x] Postman Collections



## Specs

- Oshi, JNA based native connection library (used WMI on Windows)
- SpringBoot Rest Api
- Database properties stored only JSON format
- Gui Application based on JavaFX
- Maven hierarchical project structure
- Pojo based classes
- H2 Database
- Spring Profiling 


## Request Example
```

curl -X POST \
     http://localhost:8000/sendHardwareInfo \
     -H 'Content-Type: application/json' \
     -d '{
       "doorNo": "a101",
       "os": "Microsoft Windows 10 (Home) build 17134",
       "memoryTotal": 8503046144,
       "memoryFree": 2065846272,
       "baseboard": "HP/",
       "vendor": "HP/HP Notebook",
       "serialNumber": "xxxx",
       "baseboardSerialNumber": "xxxxx",
       "cpu": {
           "model": "Intel(R) Core(TM) i5-7200U CPU @ 2.50GHz",
           "physicalCore": 2,
           "logicalCore": 4,
           "uptime": "4 days, 00:44:46",
           "bitness": 64
       },
       "gpus": [],
       "displays": [
           "  Manuf. ID=CMN, Product ID=14b6, Digital, Serial=00000000, ManufDate=12/2015, EDID v1.4\r\n  31 x 17 cm (12,2 x 6,7 in)\n  Preferred Timing: Clock 152MHz, Active Pixels 1920x1080 \n  Preferred Timing: Clock 101MHz, Active Pixels 1920x1080 \n  Manufacturer Data: 000000000000000000000000000000000000\n  Manufacturer Data: 00000002000C3DFF0D3C7D1312267D000000"
       ],
       "soundCards": [
           "SoundCard@417ebcef [kernelVersion=Intel(R) Corporation Intel(R) Ekran İçin Ses IntcDAud.sys 10.22.0.96, name=Intel(R) Corporation Intel(R) Ekran İçin Ses, codec=Intel(R) Ekran İçin Ses]",
           "SoundCard@c0500f4 [kernelVersion=Realtek Semiconductor Corp. Realtek High Definition Audio RTKVHD64.sys 6.0.1.8216, name=Realtek Semiconductor Corp. Realtek High Definition Audio, codec=Realtek High Definition Audio]"
       ],
       "usbDevices": [
           " Intel(R) USB 3.0 eXtensible Host Controller - 1.0 (Microsoft) (Genel USB xHCI Ana Bilgisayar Denetleyicisi)\n |-- USB Kök Hub (USB 3.0) ((Standart USB HUB'\''ları))\n     |-- Realtek Bluetooth 4.0 Adapter (Realtek Semiconductor Corp.)\n     |-- USB Bileşik Aygıt ((Standart USB Ana Bilgisayar Denetleyicisi))\n         |-- HP TrueVision HD (Microsoft)\n     |-- USB Bileşik Aygıt ((Standart USB Ana Bilgisayar Denetleyicisi))\n         |-- USB Giriş Aygıtı ((Standart sistem aygıtları))\n             |-- HID Klavye Aygıtı ((Standart klavyeler))\n         |-- USB Giriş Aygıtı ((Standart sistem aygıtları))\n             |-- HID uyumlu fare (Microsoft)\n         |-- USB Giriş Aygıtı ((Standart sistem aygıtları))\n             |-- HID Klavye Aygıtı ((Standart klavyeler))\n             |-- HID uyumlu satıcı tarafından tanımlanan cihaz ((Standart sistem aygıtları))\n             |-- HID uyumlu sistem denetleyicisi ((Standart sistem aygıtları))\n             |-- HID uyumlu tüketici denetimi aygıtı (Microsoft)"
       ],
       "networks": [
           {
               "name": " Name: wlan0 (Microsoft Wi-Fi Direct Virtual Adapter #6)\r\n",
               "macAdress": "94:53:30:b3:18:63",
               "ipAdress": "[]",
               "txPacket": "?",
               "rxPacket": "?"
           },
           {
               "name": " Name: wlan1 (Realtek RTL8723BE 802.11 bgn Wi-Fi Adapter)\r\n",
               "macAdress": "94:53:30:b3:18:63",
               "ipAdress": "[]",
               "txPacket": "527,7 KiB",
               "rxPacket": "4,1 MiB"
           },
           {
               "name": " Name: eth4 (VirtualBox Host-Only Ethernet Adapter)\r\n",
               "macAdress": "0a:00:27:00:00:0d",
               "ipAdress": "[10.19.19.100]",
               "txPacket": "?",
               "rxPacket": "?"
           },
           {
               "name": " Name: wlan2 (Microsoft Wi-Fi Direct Virtual Adapter #5)\r\n",
               "macAdress": "96:53:30:b3:18:63",
               "ipAdress": "[]",
               "txPacket": "?",
               "rxPacket": "?"
           },
           {
               "name": " Name: eth5 (Realtek PCIe FE Family Controller)\r\n",
               "macAdress": "98:e7:f4:f3:b0:17",
               "ipAdress": "[192.168.38.246]",
               "txPacket": "28,1 MiB",
               "rxPacket": "520,7 MiB"
           },
           {
               "dns": "[192.168.185.11]",
               "gateway": "192.168.38.1",
               "hostname": "pc",
               "domainName": "pc"
           }
       ],
       "disks": [
           {
               "name": "\\\\.\\PHYSICALDRIVE0",
               "model": "SAMSUNG MZNTY256HDHP-000H1 (Standart disk sürücüleri)",
               "serial": "xxxx",
               "size": 256052966400
           }
       ]
   }'


```
  


## License

The PC Crawler is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).



