package lab15;

//SynBlockBank.java
//ʹ��ͬ������鷽ʽʵ���߳�ͬ��
public class SynBlockBank extends Thread {
	private BankAccount account; // �����˻�
	private double money; // ����������Ϊ��Ǯ������ΪȡǮ
	public SynBlockBank(String name, BankAccount account, double money) {
		super(name);
		this.account = account;
		this.money = money;
	}

	public void run( ) {// �߳�����
		synchronized (this.account) {
			double d = this.account.getBalance( );// ��ȡĿ�˻��Ľ��
			// ��������Ľ��money<0,�����ȡǮ����,ͬʱ�ж��˻�����Ƿ����ȡǮ���
			if (money < 0 && d < -money) {
				System.out.println(money+","+this.getName( ) + "����ʧ�ܣ����㣡");
				return;
			} else {// ���˻������в���
				d += money;
				System.out.println(money+","+getName( ) + "�����ɹ���Ŀǰ�˻����Ϊ��" + d);
				try {
					Thread.sleep(100); // ����100����
				} catch (InterruptedException e) {
					e.printStackTrace( );
				}
				this.account.setBalance(d); // �޸��˻����
			}
		}
	}

	public static void main(String[] args) {
		// ����һ�������˻�ʵ��
		BankAccount myAccount = new BankAccount("60001000", 4000);
		System.out.println("�����˻������ʽ�" + myAccount.getBalance());	
		// ��������̣߳����˻����д�ȡǮ����
		SynBlockBank t1 = new SynBlockBank("T001", myAccount, -1000);
		SynBlockBank t2 = new SynBlockBank("T002", myAccount, 1000);
		SynBlockBank t3 = new SynBlockBank("T003", myAccount, -2000);
		SynBlockBank t4 = new SynBlockBank("T004", myAccount, 2000);
		// �����߳�
		t1.start( );
		t2.start( );
		t3.start( );
		t4.start( );
//		 �ȴ��������߳����
		try {
			t1.join( );
			t2.join( );
			t3.join( );
			t4.join( );
		} catch (InterruptedException e) {
			e.printStackTrace( );
		}
		// ����˻���Ϣ
		System.out.println("�˺ţ�" + myAccount.getBankNo( ) + ", ��"
				+ myAccount.getBalance( ));
	}
}
