package cp11_abstract;

// 추상매서드 오버라이드하지 않으면 오류
public class AudioPlayer extends Player {

	@Override
	void play(int pos) {

	}

	@Override
	void stop() {

	}

	// 추상 매서드가 완성이 되고 나면 
	// void play 실행됨
	
}
