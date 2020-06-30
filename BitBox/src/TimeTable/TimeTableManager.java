package TimeTable;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
/*
 *20.05.05 가격추가  
 *
 */
import java.util.LinkedList;
import java.util.Scanner;

import Movie.Movie;
import Movie.MovieManager;
import user.exception.OutOfNumberException;

public class TimeTableManager {

	private LinkedList<TimeTable> timeTableList;
	
	private int pos;
	Scanner ip = new Scanner(System.in);
	MovieManager mManager = MovieManager.getInstance();
	ScreenManager sManager = ScreenManager.getInstance();
	private static TimeTableManager ttManager = new TimeTableManager();

	public static TimeTableManager getInstatnce() {
		return ttManager;
	}

	int searchIndex;
	TimeTable ttTime;

	public TimeTableManager() {
		LocalDateTime cal0 = LocalDateTime.of(2020, 5, 13, 9, 30);
		LocalDateTime cal1 = LocalDateTime.of(2020, 5, 13, 13, 30);
		LocalDateTime cal2 = LocalDateTime.of(2020, 5, 13, 17, 30);
		LocalDateTime cal3 = LocalDateTime.of(2020, 5, 13, 21, 30);
		// 미리 시간을 4개 지정해놓음
		
				timeTableList = new LinkedList<>(); // timeTableList 객체 생성
				timeTableList.add(new TimeTable(mManager.getMovieList().get(1), 
								 new Screen(sManager.screenList.get(0).getName(),
											sManager.screenList.get(0).getSeats().length,
											sManager.screenList.get(0).getSeats()[0].length,
											sManager.screenList.get(0).getPrice()), cal0)); 
				// timeTableList에 새로운 TimeTable 객체 [ 1번째인덱스 영화, 0번째 스크린정보를 새로운 스크린객체저장 , 미리 정해놓은 cal0 번재 시간 ]
				
				timeTableList.add(new TimeTable(mManager.getMovieList().get(2), 
						 		 new Screen(sManager.screenList.get(0).getName(),
						 				 	sManager.screenList.get(0).getSeats().length,
						 				 	sManager.screenList.get(0).getSeats()[0].length,
						 				 	sManager.screenList.get(0).getPrice()), cal2));
				// timeTableList에 새로운 TimeTable 객체 [ 2번째인덱스 영화, 0번째 스크린정보를 새로운 스크린객체저장 , 미리 정해놓은 cal2 번재 시간 ]
				
				timeTableList.add(new TimeTable(mManager.getMovieList().get(3), 
						 		 new Screen(sManager.screenList.get(1).getName(),
						 				 	sManager.screenList.get(1).getSeats().length,
						 				 	sManager.screenList.get(1).getSeats()[0].length,
						 				 	sManager.screenList.get(1).getPrice()), cal1));
				// timeTableList에 새로운 TimeTable 객체 [ 3번째인덱스 영화, 1번째 스크린정보를 새로운 스크린객체저장 , 미리 정해놓은 cal1 번재 시간 ]
				
				timeTableList.add(new TimeTable(mManager.getMovieList().get(0), 
						 		 new Screen(sManager.screenList.get(1).getName(),
						 					sManager.screenList.get(1).getSeats().length,
						 					sManager.screenList.get(1).getSeats()[0].length,
						 					sManager.screenList.get(1).getPrice()), cal3));
				// timeTableList에 새로운 TimeTable 객체 [ 0번째인덱스 영화, 1번째 스크린정보를 새로운 스크린객체저장 , 미리 정해놓은 cal3 번재 시간 ]
				
				timeTableList.add(new TimeTable(mManager.getMovieList().get(3), 
								 new Screen(sManager.screenList.get(2).getName(),
										 	sManager.screenList.get(2).getSeats().length,
										 	sManager.screenList.get(2).getSeats()[0].length,
										 	sManager.screenList.get(2).getPrice()), cal0));
				// timeTableList에 새로운 TimeTable 객체 [ 3번째인덱스 영화, 2번째 스크린정보를 새로운 스크린객체저장 , 미리 정해놓은 cal0 번재 시간 ]
				
				timeTableList.add(new TimeTable(mManager.getMovieList().get(1), 
						 	 	 new Screen(sManager.screenList.get(2).getName(),
						 	 			 	sManager.screenList.get(2).getSeats().length,
						 	 			 	sManager.screenList.get(2).getSeats()[0].length,
						 	 			 	sManager.screenList.get(2).getPrice()), cal2));
				// timeTableList에 새로운 TimeTable 객체 [ 1번째인덱스 영화, 2번째 스크린정보를 새로운 스크린객체저장 , 미리 정해놓은 cal2 번재 시간 ]
				
				timeTableList.add(new TimeTable(mManager.getMovieList().get(2), 
						 		 new Screen(sManager.screenList.get(2).getName(),
						 				 	sManager.screenList.get(2).getSeats().length,
						 				 	sManager.screenList.get(2).getSeats()[0].length,
						 				 	sManager.screenList.get(2).getPrice()), cal3));
				// timeTableList에 새로운 TimeTable 객체 [ 2번째인덱스 영화, 2번째 스크린정보를 새로운 스크린객체저장 , 미리 정해놓은 cal3 번재 시간 ]
				
				timeTableList.add(new TimeTable(mManager.getMovieList().get(1), 
						 		 new Screen(sManager.screenList.get(3).getName(),
						 				 	sManager.screenList.get(3).getSeats().length,
						 				 	sManager.screenList.get(3).getSeats()[0].length,
						 				 	sManager.screenList.get(3).getPrice()), cal0));
				// timeTableList에 새로운 TimeTable 객체 [ 1번째인덱스 영화, 3번째 스크린정보를 새로운 스크린객체저장 , 미리 정해놓은 cal0 번재 시간 ]
				
				timeTableList.add(new TimeTable(mManager.getMovieList().get(1), 
						 		 new Screen(sManager.screenList.get(3).getName(),
						 				 	sManager.screenList.get(3).getSeats().length,
						 				 	sManager.screenList.get(3).getSeats()[0].length,
						 				 	sManager.screenList.get(3).getPrice()), cal1));
				// timeTableList에 새로운 TimeTable 객체 [ 1번째인덱스 영화, 3번째 스크린정보를 새로운 스크린객체저장 , 미리 정해놓은 cal1 번재 시간 ]
				
				timeTableList.add(new TimeTable(mManager.getMovieList().get(3), 
							 	 new Screen(sManager.screenList.get(3).getName(),
							 			 	sManager.screenList.get(3).getSeats().length,
							 			 	sManager.screenList.get(3).getSeats()[0].length,
							 			 	sManager.screenList.get(3).getPrice()), cal2));
				// timeTableList에 새로운 TimeTable 객체 [ 3번째인덱스 영화, 3번째 스크린정보를 새로운 스크린객체저장 , 미리 정해놓은 cal2 번재 시간 ]
				
				timeTableList.add(new TimeTable(mManager.getMovieList().get(0), 
						 		 new Screen(sManager.screenList.get(3).getName(),
						 				 	sManager.screenList.get(3).getSeats().length,
						 				 	sManager.screenList.get(3).getSeats()[0].length,
						 				 	sManager.screenList.get(3).getPrice()), cal3));
				// timeTableList에 새로운 TimeTable 객체 [ 0번째인덱스 영화, 3번째 스크린정보를 새로운 스크린객체저장 , 미리 정해놓은 cal3 번재 시간 ]
				

			}


	Movie selectMovie() {
		int selectM;
		System.out.println("<<영화 목록>>");
		for (int i = 0; i < mManager.getMovieList().size(); i++) {
			System.out.print(i +1+ ") ");
			System.out.println(mManager.getMovieList().get(i).getTitle());
		} // 기존에 만들어져 저장된 영화 list를 출력함
		while(true) {
			System.out.println("▶ 시간 표에 입력하실 영화 선택 :  ");
			try {
				selectM = Integer.parseInt(ip.nextLine().trim())-1; // 기존 영화리스트중 원하는 인덱스 선택
				if(selectM < 0 || selectM >= mManager.getMovieList().size()) {
					OutOfNumberException e = new OutOfNumberException();
					throw e;
				}
			} catch (OutOfNumberException e) {
				System.out.println(e.getMessage());
				continue;
			}catch (Exception e) {
				System.out.println("■ 메뉴를 잘못 입력하셨습니다. 다시 입력해주세요 ■\n");
				continue;
			}
			break;
		}
		return mManager.getMovieList().get(selectM); // 선택한 영화 인덱스를 리턴시킴
	}

	Screen selectScreen() {
		int selectS;
		Screen screen;
		System.out.println("<<상영관 목록>>");
		for (int i = 0; i < sManager.screenList.size(); i++) {
			System.out.print(i +1+ ") ");
			System.out.println(sManager.screenList.get(i).getName());
		}// 기존 상영관스크린에 스크린을 출력
		while(true) {
			System.out.println("▶ 영화를 상영할 상영관 선택 : ");
			try {
				selectS = Integer.parseInt(ip.nextLine().trim())-1;// 기존 상영관스크린중 원하는 인덱스 선택
				if(selectS < 0 || selectS >= sManager.screenList.size()) { 
					OutOfNumberException e = new OutOfNumberException();
					throw e;
				}
			} catch (OutOfNumberException e) {
				System.out.println(e.getMessage());
				continue;
			}catch (Exception e) {
				System.out.println("■ 메뉴를 잘못 입력하셨습니다. 다시 입력해주세요 ■\n");
				continue;
			}
			break;
		}
		screen = new Screen(sManager.screenList.get(selectS).getName(),
							sManager.screenList.get(selectS).getSeats().length,
							sManager.screenList.get(selectS).getSeats()[0].length,
							sManager.screenList.get(selectS).getPrice());
		//선택한 스크린인덱스의 객체정보를 똑같이 새로 스크린생성함
		
		return screen;// 새로생성한 스크린을 리턴시킴
	}

	LocalDateTime selectTime(Movie movie, Screen screen) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		int selectDay = 0;
		int h = 0;
		int min = 0;
		Loop1 :while(true) {
			LocalDateTime cal = LocalDateTime.now(); // 1970년 x  현재시간기준 o
			for (int i = 1; i < 5; i++) {
				System.out.print(i + ") ");
				System.out.print(cal.getMonthValue() + "월"); // 현재 달에 "월" 붙임 -> 5월
				System.out.println(cal.getDayOfMonth() + i + "일"); //  현재 일에 "일"을 붙이고 현재일 +1~4일 까지 출력
			
			}
			while(true) {
				try {
					System.out.println("▶ 상영 날짜 선택해주세요 \n>>"); 
					selectDay = Integer.parseInt(ip.nextLine().trim());
					if (selectDay <1 || selectDay > 4) { // 현재 일 +1~4 범위내에서만 입력가능
						OutOfNumberException e = new OutOfNumberException();
						throw e;
					}
				} catch (OutOfNumberException e) {
					System.out.println(e.getMessage());
					continue;
				}catch (Exception e) {
					System.out.println("■ 메뉴를 잘못 입력하셨습니다. 다시 입력해주세요 ■\n");
					continue;
				}
				break;
			}
			while(true) {
				try {
					System.out.println("▶ 상영할 시간을 입력해주세요(시간, 분) \n 시간입력(0~23시)\n>>");
					h = Integer.parseInt(ip.nextLine().trim());
					System.out.println("분 입력 \n>>");
					min = Integer.parseInt(ip.nextLine().trim());
					
				} catch (Exception e) {
					System.out.println("■ 잘못된 입력입니다. 다시 입력해주세요 ■\n");
					continue;
				}
				break;
			}
			int d = 0;
			if (min >= 60) {
				h += min / 60;
				min = min % 60;
			}
			if (h >= 24) {
				d = d + (h / 24);
				h = h % 24;
			}
			cal = cal.plusDays(selectDay + d).withHour(h).withMinute(min); //  입력시간 Date저장
			LocalDateTime cal2 = cal.plusMinutes(movie.getRuntime()); // 종료시간 기존 저장된 date+ runtime
			ArrayList<TimeTable> matchScreen = new ArrayList<>(); // TimeTable 저장된 정보를 List로 저장
			for (int i = 0; i < timeTableList.size(); i++) {
				if (timeTableList.get(i).getScreen().getName().equals(screen.getName())) { // 스크린이름 인덱스를 내가 선택한 스크린이름 인덱스와 비교
					matchScreen.add(timeTableList.get(i)); // 같은 스크린이름 인덱스의 값들만 List에 저장
				}
			}

			for (int i = 0; i < matchScreen.size(); i++) {  // 빼온 List 사이즈만큼 반복
				if (matchScreen.get(i).getStartTime().isBefore(cal) && matchScreen.get(i).getEndTime().isAfter(cal)
						// 빼온list 의 영화 시작시간과 지금 적은 시작시간 [cal]을 앞선 시간인지 비교한다 시작시간이 cal보다 이전이면 참
						// 빼온list 의 영화 종료시간과 지금 적은 시작시간 [cal]을 이후 시간인지 비교한다 종료시간이 cal보다 이전이면 거짓
						
						|| matchScreen.get(i).getStartTime().isBefore(cal2)
//						빼온 list의 영화 시작시간이 지금 적은 종료시간 [cal2]을 앞선 시간인지 비교한다 시작시간이 cal2보다 이전이면 참
						
						&& matchScreen.get(i).getEndTime().isAfter(cal2)
//						빼온list 의 영화 종료시간과 지금 적은 종료시간 [cal2]을 이후 시간인지 비교한다 종료시간이 cal2보다 이전이면 거짓
								
						|| matchScreen.get(i).getStartTime().isAfter(cal)
						// // 빼온list 의 영화 종료시간과 지금 적은 시작시간 [cal]을 이후 시간인지 비교한다 종료시간이 cal보다 이전이면 거짓
						
						&& matchScreen.get(i).getEndTime().isBefore(cal2)) {
					// 빼온list 의 영화 종료시간과 지금 적은 종료시간 [cal2]을 이후 시간인지 비교한다 종료시간이 cal2보다 이전이면 거짓
					System.out.println("■  이미 등록된 스케쥴이 있습니다. 다시 입력하세요. ■ \n");
					continue Loop1;
				}
			}
			System.out.println("<<입력한 시간표>>");
			System.out.print(cal.getMonthValue()+"월 "); // 리턴 시킨 cal의 월을 출력
			System.out.println(cal.getDayOfMonth()+"일"); // 리턴 시킨 cal의 일을 출력
			System.out.println(dtf.format(cal)+"~"+dtf.format(cal2)); // 운영자가 입력한 시작시간 , 종료시간을 출력
			System.out.println("● 영화제목 : "+movie.getTitle());
			System.out.println("● 상 영 관 : "+screen.getName());
			return cal; // Date cal시간에 리턴시킨다
		}
	}
	
	TimeTable createTimeInst() {

		ttTime = null;
 
		Movie movie = selectMovie(); // 위에서 선택한 영화
		Screen screen = selectScreen(); // 위에서 선택한 똑같은 정보의 새로운 스크린

		LocalDateTime cal = selectTime(movie, screen);
		System.out.println();
		ttTime = new TimeTable(movie, screen, cal); // ttTime에 영화 스크린 시간 값을 새로운 객체로 저장시킴
 
		return ttTime; // 새로운 객체를 리턴시킴
	}

	void addInst(TimeTable ttTime) {
		System.out.println("-------- 새로운 시간표가 등록되었습니다  -------- \n");
		timeTableList.add(ttTime); // 새로운 객체를 timeTableList에 추가함
	}

	/*
	 * public int searchIndexNum(String movie) {
	 * 
	 * searchIndex = -1;
	 * 
	 * for(int i=0;i<timeTableList.size();i++) {
	 * if(timeTableList.get(i).checkTimeTable(movie)) { searchIndex=i; break; } }
	 * return searchIndex; }
	 * 
	 */

	void edit() {

		System.out.println("------ 수정할 목록을 고르세요  ------");	

		for (int i = 0; i < timeTableList.size(); i++) {
			System.out.print(i + ") ");
			timeTableList.get(i).showTimeTable();
		}

		int index = ip.nextInt();
		ip.nextLine();

		System.out.println("1. 영화 수정");
		System.out.println("2. 상영관 수정");
		System.out.println("3. 시간 수정");

		int choice = ip.nextInt();
		ip.nextLine();

		switch (choice) {
		case 1:
			
			Movie changeMovie = selectMovie();

			timeTableList.get(index).setMovie(changeMovie);
			System.out.println("-------- 상영 영화가 수정되었습니다  -------- \n");

			break;

		case 2:
			Screen changeScreen = selectScreen();

			timeTableList.get(index).setScreen(changeScreen);
			System.out.println("-------- 상영관이 수정되었습니다  -------- \n");

			break;
		case 3:
			LocalDateTime changeTime = selectTime(timeTableList.get(index).getMovie(), timeTableList.get(index).getScreen());
			timeTableList.get(index).setStartTime(changeTime);
			
			System.out.println("-------- 상영 영화가 수정되었습니다  -------- \n");

		}
	}

	public LinkedList<TimeTable> getTable() {
		return timeTableList;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

}
