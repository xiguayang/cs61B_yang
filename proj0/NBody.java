public class NBody{

  public static String imageBackground = "images/starfield.jpg";

  public static double readRadius(String fileName){
    In in;
    double radius = 0.0;
    try {
        in = new In(fileName);
        while (!in.isEmpty()) {
          int line = in.readInt();
          radius = in.readDouble();
        }
    }
    catch (Exception e) { System.out.println(e); }
    return radius;
  }

  public static Body[] readBodies(String fileName){
    In in;
    double radius = 0.0;
    int line = 0;
    Body[] bodies = {};
    double xp = 0.0;
    double yp = 0.0;
    double xv = 0.0;
    double yv = 0.0;
    double m = 0.0;
    String img = null;
    try {
        in = new In(fileName);
        while (!in.isEmpty()) {
          line = in.readInt();
          radius = in.readDouble();
          bodies = new Body[line];
          for (int i =0;i<line;i++){
              xp = in.readDouble();
              yp = in.readDouble();
              xv =in.readDouble();
              yv = in.readDouble();
              m = in.readDouble();
              img = in.readString();
              bodies[i]= new Body(xp,yp,xv,yv,m,img);
          }
        }
    }
    catch (Exception e) { System.out.println(e); }
    return bodies;

  }


  public static void main(String[] args) {
    double time = 0.0;
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];
    double radius = readRadius(filename);
    Body[] bodies = readBodies(filename);
    StdDraw.enableDoubleBuffering();
    StdDraw.setScale(-radius, radius);
    int numOfbodies=bodies.length;
    while(time<=T){
      double[] xForces= new double[numOfbodies];
      double[] yForces =new double[numOfbodies];
      for(int i = 0;i<numOfbodies;i++){
        xForces[i]= bodies[i].calcNetForceExertedByX(bodies);
        yForces[i]= bodies[i].calcNetForceExertedByY(bodies);
      }
      for(int j = 0; j<numOfbodies;j++){
        bodies[j].update(dt,xForces[j],yForces[j]);
      }
      StdDraw.clear();
      StdDraw.picture(0, 0, imageBackground,radius*2,radius*2);
      for(Body body : bodies) body.draw();
      StdDraw.show();
      StdDraw.pause(10);
      time = time + dt;
    }
    StdOut.printf("%d\n", bodies.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < numOfbodies; i++) {
      StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
    }
  }
}
