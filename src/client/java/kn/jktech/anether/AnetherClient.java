package kn.jktech.anether;

import com.fox2code.foxloader.loader.ClientMod;

public class AnetherClient extends Anether implements ClientMod {
    @Override
    public void onInit() {
        System.out.println("!!! ANETHER !!! hoi");
        // Client specific code
    }
}
