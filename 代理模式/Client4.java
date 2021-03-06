interface IProxy {
	public void count();
}

interface IGamePlayer {
	//登录游戏
	public void login(String user, String password);
	//杀怪，网络游戏的主要特色
	public void killBoss();
	//升级
	public void upgrade();
	//每个人都可以找一下自己的代理
	public IGamePlayer getProxy();
}

class GamePlayer implements IGamePlayer {
	private String name = "";
	private IGamePlayer proxy = null;
	//通过构造函数传递名称
	public GamePlayer(String _name) {
		this.name = _name;
	}
	public IGamePlayer getProxy() {
		this.proxy = new GamePlayerProxy(this);
		return this.proxy;
	}
	//打怪，最期望的就是杀老妖怪
	public void killBoss() {
		if(this.isProxy()) {
			System.out.println(this.name + "在打怪!");
		} else {
			System.out.println("请使用指定的代理访问");
		}
	}

	//登录
	public void login(String user, String password) {
		if(this.isProxy()) {
			System.out.println("登录名为" + user + "的用户" + this.name + "登录成功!");
		} else {
			System.out.println("请使用指定的代理访问");
		}
	}
	//升级
	public void upgrade() {
		if(this.isProxy()) {
			System.out.println(this.name + "又升了一级!");
		} else {
			System.out.println("请使用指定的代理访问");
		}
	}
	//校验是否是代理访问
	private boolean isProxy() {
		if(this.proxy == null) {
			return false;
		} else {
			return true;
		}
	}
}

class GamePlayerProxy implements IGamePlayer, IProxy {
	private IGamePlayer gamePlayer = null;
	public GamePlayerProxy(IGamePlayer _gamePlayer) {
		this.gamePlayer = _gamePlayer;
	}
	//代练杀怪
	public void killBoss() {
		this.gamePlayer.killBoss();
	}
	//代练登录
	public void login(String user, String password) {
		this.gamePlayer.login(user, password);
	}
	public void upgrade() {
		this.gamePlayer.upgrade();
		this.count();
	}
	public void count() {
		System.out.println("升级总费用是：150元");
	}
	public IGamePlayer getProxy() {
		return this;
	}
}

public class Client4 {
	public static void main(String[] args) {
		//定义一个痴迷的玩家
		IGamePlayer player = new GamePlayer("张三");
		//定义一个代练者
		IGamePlayer proxy = player.getProxy();
		//开始打游戏，记下时间戳
		System.out.println("开始时间是: 2009-8-25 10:45");
		proxy.login("zhangsan", "password");
		//开始杀怪
		proxy.killBoss();
		//升级
		proxy.upgrade();
		//记录结束游戏时间
		System.out.println("结束时间是: 2009-8-26 03:40");
	}
}