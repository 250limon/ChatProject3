package utils;

import java.util.Random;

//随机数生成器
public class RandomGenerator {
    private static Random random=new Random();
    //生成a 到b的左闭右开的数
    public static  int random(int a,int b)
    {
        return random.nextInt(b-a)+a;
    }
}
