package lab6;
//�Զ����쳣��MotorException�����̳���Exception��
class MotorException extends Exception{
	public MotorException(){super();}
	public MotorException(String s){super(s);}
}

class Car{
	private float speed= 0;
	private float MAX_V = 300;
	//˵�����ø÷��������׳�MotorException�쳣
	public void accelerate(float inc) throws MotorException{	
		if(speed+inc > MAX_V){	
			//�׳�MotorException�쳣ʵ������ʾ�������������ٻ�����
			throw new MotorException("�����������ٻ���"); 
 		}else{
			speed+=inc;
		}
	}
}

public class Lab6_6 {
	public static Car car;
	public static void main(String args[]){
		car= new Car();
		try{		//���������쳣�Ŀ�
			for(;;)
				car.accelerate(0.5f);
		}catch(MotorException me){	//���񡢴����쳣
			System.out.println("Mechanical problem: "+me);
		}
	}
}
