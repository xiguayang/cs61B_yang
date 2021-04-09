public class Body{
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;
  public static double G = 6.67E-11;

  public Body(double xP, double yP, double xV, double yV, double m, String img){
    this.xxPos = xP;
    this.yyPos = yP;
    this.xxVel = xV;
    this.yyVel = yV;
    this.mass = m;
    this.imgFileName = img;
  }

  public Body(Body b){
    this.xxPos = b.xxPos;
    this.yyPos = b.yyPos;
    this.xxVel = b.xxVel;
    this.yyVel = b.yyVel;
    this.mass = b.mass;
    this.imgFileName = b.imgFileName;
  }

  public double calcDistance(Body b){
    double distance;
    distance = Math.sqrt(Math.pow((this.xxPos - b.xxPos),2)+ Math.pow((this.yyPos - b.yyPos),2));
    return distance;
  }

  public double calcForceExertedBy(Body b){
    double r = calcDistance(b);
    double forceBy = G*this.mass*b.mass/Math.pow(r,2);
    return forceBy;
  }

  public double calcForceExertedByX(Body b){
    double r = calcDistance(b);
    double forceBy = calcForceExertedBy(b);
    double dx = b.xxPos - this.xxPos;
    double forceByX = forceBy * dx / r;
    return forceByX;
  }

  public double calcForceExertedByY(Body b){
    double r = calcDistance(b);
    double forceBy = calcForceExertedBy(b);
    double dy = b.yyPos - this.yyPos;
    double forceByY = forceBy * dy /r;
    return forceByY;
  }


  public double calcNetForceExertedByX(Body[] bodys){
    double forceNetX=0.0;
    for(int i = 0; i<bodys.length;i++){
      if (!this.equals(bodys[i])){
        forceNetX = forceNetX+this.calcForceExertedByX(bodys[i]);
      }

    }
    return forceNetX;
  }

  public double calcNetForceExertedByY(Body[] bodys){
    double forceNetY=0.0;
    for(int i = 0; i<bodys.length;i++){
      if (!this.equals(bodys[i])){
        forceNetY = forceNetY + this.calcForceExertedByY(bodys[i]);
      }
    }
    return forceNetY;
  }

  public void update(double dt,double fx, double fy){
    double ax = fx/this.mass;
    double ay = fy/this.mass;
    this.xxVel = this.xxVel + dt * ax;
    this.yyVel = this.yyVel + dt * ay;
    this.xxPos = this.xxPos + dt * this.xxVel;
    this.yyPos = this.yyPos + dt * this.yyVel;
  }

  public void draw(){
    StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
  }

}
