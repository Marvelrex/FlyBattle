package airPlaneGame;

import java.awt.image.BufferedImage;

/**
 * this is hero class which is a subclass of FlyingObject
 */
public class Hero extends FlyingObject {
    protected BufferedImage[] images;
    private int life;
    private int doubleFire;
    private int index;

    /**
     * this is hero constructor method
     */
    public Hero(){
         image = ShootGame.hero0;
         width = image.getWidth();
         height = image.getHeight();
         life = 3;
         x = 150;
         y = 400;
         doubleFire = 0;
        images = new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
        index = 0;

    }

	@Override
	public void step() {//10������һ��
		///ÿ100�����л�һ��

		index++;
		int a = index/10;
		int b = a%2;
		image = images[index/10%images.length];

		/*
		 * 10m index=1 a=0 b=0
		 * 20m index=2 a=0 b=0
		 * 30m index=3 a=0 b=0
		 * ...
		 * 100m index=10 a=1 b=1
		 * 110m index=11 a=1 b=1
		 * 120m index=12 a=1 b=1
		 * ...
		 * 200m index=20 a=2 b=0
		 * 210m index=21 a=2 b=0
		 * ...
		 * 300m index=30 a=3 b=1
		 */
		
	}

    @Override
    public boolean outOfBounds() {
        return false;//Ӣ�ۻ���Զ����Խ��
    }

    public Bullet[] shoot(){
		int xStep = this.width/4; //Ӣ�ۻ���1/4��
		if(doubleFire>0){ //˫��
			Bullet[] bullets = new Bullet[2];
			bullets[0] = new Bullet(this.x+1*xStep,this.y-20); //x:Ӣ�ۻ�x+1/4Ӣ�ۻ��� y:Ӣ�ۻ�y-20
			bullets[1] = new Bullet(this.x+3*xStep,this.y-20); //x:Ӣ�ۻ�x+3/4Ӣ�ۻ��� y:Ӣ�ۻ�y-20
			doubleFire -= 2; //����һ��˫��������ֵ��2
			return bullets;
		}else{ //����
			Bullet[] bullets = new Bullet[1];
			bullets[0] = new Bullet(this.x+2*xStep,this.y-20); //x:Ӣ�ۻ�x+2/4Ӣ�ۻ��� y:Ӣ�ۻ�y-20
			return bullets;
		}
	}

	/**
	 * Ӣ�ۻ���������ƶ�
	 */
	public void moveTo(int x,int y){
        this.x = x-this.width/2;
        this.y = y-this.height/2;
	}

	public void addLife(){
	    life++;
    }

    public int getLife(){
		return life;
	}


    public void addDoubleFire(){
	    doubleFire += 40;
    }

    public boolean hit(FlyingObject object){
    	 int x1 = object.x-this.width/2;
    	 int x2 = object.x+object.width+this.width/2;
  		 int y1 = object.y-this.height/2;
  		 int y2 = object.y+object.height+this.height/2;
		 int hx = this.x+this.width/2;
		 int hy = this.y+this.height/2;
		 return ((x1<hx)&&(hx<x2) )&& ((y1<hy) &&(hy<y2));
	}

	public void subtractLife(){
    	life--;
	}

	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}



}
