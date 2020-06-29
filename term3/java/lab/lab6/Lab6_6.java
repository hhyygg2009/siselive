package lab6;
//自定义异常类MotorException，它继承了Exception类
class MotorException extends Exception{
	public MotorException(){super();}
	public MotorException(String s){super(s);}
}

class Car{
	private float speed= 0;
	private float MAX_V = 300;
	//说明调用该方法可能抛出MotorException异常
	public void accelerate(float inc) throws MotorException{	
		if(speed+inc > MAX_V){	
			//抛出MotorException异常实例，提示”发动机将被毁坏！”
			throw new MotorException("发动机将被毁坏！"); 
 		}else{
			speed+=inc;
		}
	}
}

public class Lab6_6 {
	public static Car car;
	public static void main(String args[]){
		car= new Car();
		try{		//可能引发异常的块
			for(;;)
				car.accelerate(0.5f);
		}catch(MotorException me){	//捕获、处理异常
			System.out.println("Mechanical problem: "+me);
		}
	}
}
