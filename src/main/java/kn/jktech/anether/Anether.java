package kn.jktech.anether;

import com.fox2code.foxloader.loader.Mod;
import com.fox2code.foxloader.registry.*;

import java.util.Random;

public class Anether extends Mod {
    private static final Random random = new Random();
    private static final int[] loots = new int[]{
            280, // Stick
            287, // String
            288, // Feather
            289, // Gunpowder
            295, // Seeds
            318, // Flint
            405, // Ash
    };
    public static RegisteredBlock ratBlock;

    @Override
    public void onPreInit() {
        log("initializing");
    }
public static void log(String str){System.out.println("!!! ANETHER !!! "+str);}
    public static int randomLootId() {
        if (random.nextInt(256) == 0)
            return 264; // Diamond
        return loots[random.nextInt(loots.length)];
    }
}
