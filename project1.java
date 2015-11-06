   //Project 1, monster who chases the hero and hero chases the gold
    // Luis Fuentes
    // CST 112
    
    //// GLOBALS ////
    float goldX, goldY;
    float marioX, marioY;
    float ronaldX, ronaldY; 
    float sunX, sunY;
    float horizon;
    int score;
    
    
    void setup() {
      size(850, 500);
      horizon= height/4;
      sunX =-50;
      goldX= random(width/4, width *3/4);
      goldY= random(height/3.2, height *3/4);
      marioX=270;
      marioY=80;
      ronaldX=10;
      ronaldY=random(height/5, height);
      score=0;
      reset();
    }
    void draw() {
      drawScene();
      drawGold(goldX, goldY);
      drawHero();
      drawMonster();
      drawHouse(20, 30);
      interaction();
      displayScore();
      button();
      drawSun();
      displayScore();
    }
    void reset() {
      goldX = random(width/4, width *3/4);
      goldY =random(height/3.2, height *3/4) ;
      ronaldX= 10;
      ronaldY=random(height/5, height) ;
      marioX= 270;
      marioY= 80;
      drawSun();
    }
    
    void drawScene() {
      background(100, 170, 225); //sky
      fill(100, 200, 100);
      rect(0, horizon, width, height*3/4); //grass
    }
    void drawHouse(float x, float y) {
      fill(255, 155, 75);
    
      stroke(0, 0, 0, 0);
    
      rect(350, horizon-70, 100, horizon-50);
      fill(25, 100, 65);
      rect(393, horizon-25, 15, horizon-95);
      fill(50, 50, 100);
      rect(350, horizon-70, 100, horizon-80);
    
      fill(90, 100, 20);
      triangle(425, horizon-30, 400, horizon-69, 375, horizon-30  );
      fill(250, 25, 100);
      rect(360, horizon-25, 20, horizon-105);     
      rect(420, horizon-25, 20, horizon-105);  
      stroke(0, 0, 0);
      strokeWeight(3);
      point(404, 105);
      fill(0);
    }
    void drawGold(float x, float y) {
      fill(250, 255, 100);
      rect(x, y, 10, 10);
    }
 void leg( float x, float hip, float toe ) {
            line( x,hip, x+toe,hip+40 );
    }    
    void drawHero() { 
      fill(190,100,100); 
      rect(marioX,marioY-20,30,30);
      fill(100,100,190);
      ellipse(marioX+10,marioY-10,5,5);
      ellipse(marioX+20,marioY-10,5,5);
      fill(100,100,100);
      rect(marioX, marioY, 30, 90);
      float dx = goldX - marioX;
      marioX += dx * 0.05;
      float dy = goldY - marioY;
      marioY += dy * 0.05;
      stroke(100,100,100);
      strokeWeight(8);
      float toe=5;
      if ( (frameCount/30) % 2 > 0) { toe=  -5; }        // Odd frames:  move toe left 
      leg( marioX+5, marioY+90, toe ); 
      leg( marioX+25, marioY+90, toe ); //
      leg( marioX+30, marioY+20, toe+20 ); 
      leg( marioX, marioY+20, toe-20 ); 
      strokeWeight(1);
    }
    void drawMonster() {
      fill(250, 100, 100);
      rect(ronaldX, ronaldY, 20, 40);
      float dx = marioX - ronaldX;
      ronaldX += dx * 0.035;
      float dy = marioY - ronaldY;
      ronaldY += dy * 0.035;
    }
    
    
    void interaction() {
      if (abs(marioX-goldX)<2 && abs(marioY-goldY)<2) {
        goldX = random(width/4, width*3/4);
        goldY = random(height/3.2, height*3/4);
        marioX= 260;
        marioY= 70;
        score = score + 50;
      }
      if (abs(ronaldX-marioX)<10 && abs(ronaldY-marioY)<10) {
        score = score - 100;
        goldX = random(width/4, width*3/4);
        goldY = random(height/3.2, height*3/4);
        ronaldX= 0;
        ronaldY= random(height/4, height);
        marioX= width;
        marioY= random(height/4, height);
      }
    }
    void drawSun() {
      noStroke();
      fill(255, 255, 0);
      sunY = -sqrt(pow(1500,2)-pow(sunX-320, 2))+1500;
      sunX=sunX+1;
      ellipse(sunX,sunY,50,50);
      if(sunX>width+50){
        sunX=-50;
    }
    }

    void displayScore() {
      fill(0);
      strokeWeight(4);
      rect(750, 400, 83, 17);
      fill(255);
      text("Score", 760, 400+15);
      text(score, 750+65, 400+15);
    }
    void buttonBasic(float fill) {
      fill(fill);
  
    
      rect(750, 300, 83, 30);
      fill(255);
      text("Reset", 770, 320);
    }
    void button() {
      buttonBasic(0);
      if (mouseX >750 && mouseX<833 && mouseY>300 && mouseY<330) {
        ;
      }
    }
     
    
    void mousePressed() {
      if (mouseX >750 && mouseX<833 && mouseY>300 && mouseY<330) {
        reset();
        score= score -50;
        buttonBasic(200);
      }
    }
    
    void keyPressed() {
      if (key == 'q') {
        exit();
      }
    }
