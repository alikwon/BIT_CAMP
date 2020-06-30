import time
from selenium.webdriver import Chrome

chromeDriver = 'C:\\temp\\chromedriver.exe'

driver = Chrome(chromeDriver)

driver.get('https://login.11st.co.kr/auth/front/login.tmall')

time.sleep(3)
#끼워넣고 난다음에 불러오기위에 슬립

input_login = driver.find_element_by_id('loginName')
input_login.send_keys('bs0984544')

input_pw = driver.find_element_by_id('passWord')
input_pw.send_keys('ahrl8383')

btn = driver.find_element_by_class_name('btn_Atype')

time.sleep(3)

btn.click()

time.sleep(3)

driver.get('http://buy.11st.co.kr/order/OrderList.tmall')

time.sleep(3)

driver.quit()