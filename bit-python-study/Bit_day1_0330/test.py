
import requests
from bs4 import BeautifulSoup

url = "https://comic.naver.com/webtoon/weekdayList.nhn?week=tue"

req = requests.get(url)

print(req)# get은 단순히 응답코드만 가져옵니다.

html = req.text	 # html내용을 가져오기 위해 text를 가져옵니다. 인코딩이 안 맞을 경우에는 인코딩 방식을 바꾸거나 .content를 쓸 수 있습니다.

#print(html)

soup = BeautifulSoup(html, 'html.parser')
result = soup.select('.thumb')

print(result)