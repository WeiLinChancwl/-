import java.util.*;

interface Human {
	public void getColor();
	public void talk();
}
class BlackHuman implements Human {
	public void getColor() {
		System.out.println("黑色人种的肤色是黑色的");
	}
	public void talk() {
		System.out.println("黑色人种会说话，一般人听不懂");
	}
}
class YelloHuman implements Human {
	public void getColor() {
		System.out.println("黄色人种的肤色是黄色的！");
	}
	public void talk() {
		System.out.println("黄色人种会说话，一般说的的是双字节。");
	}
}
class WhiteHuman implements Human {
	public void getColor() {
		System.out.println("白色人种的肤色是白色的！");
	}
	public void talk() {
		System.out.println("白色人种会说话");
	}
}
abstract class AbstractHumanFactory {
	public abstract Human createHuman();
}
class BlackHumanFactory extends AbstractHumanFactory {
	public Human createHuman() {
		return new BlackHuman();
	}
}
class YelloHumanFactory extends AbstractHumanFactory {
	public Human createHuman() {
		return new YelloHuman();
	}
}
class WhiteHumanFactory extends AbstractHumanFactory {
	public Human createHuman() {
		return new WhiteHuman();
	}
}

public class NvWa3 {
	public static void main(String[] args) {
		System.out.println("--造出的第一批人是白色人种--");
		Human whiteHuman = (new WhiteHumanFactory()).createHuman();
		whiteHuman.getColor();
		whiteHuman.talk();
		System.out.println("造出的第二批人种是黑色人种--");
		Human blackHuman = (new BlackHumanFactory()).createHuman();
		blackHuman.getColor();
		blackHuman.talk();
		System.out.println("造出的第三批人种是黄色人种--");
		Human yelloHuman = (new YelloHumanFactory()).createHuman();
		yelloHuman.getColor();
		yelloHuman.talk();
	}
}