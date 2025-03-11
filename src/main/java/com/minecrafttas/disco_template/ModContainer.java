package com.minecrafttas.disco_template;

import net.fabricmc.api.ModInitializer;

public class ModContainer implements ModInitializer{

	@Override
	public void onInitialize() {
		System.out.println("Hello Disco World!");
		
		//////////////////////////////////
		// To do version specific code: //
		//////////////////////////////////
		
		//#1.16.1
//$$		System.out.println("Only enabled in 1.16.1 and above");
		//#end
		
		
		////////////////////////////////////////
		// You can add multiple versions too: //
		////////////////////////////////////////
		
		//# 1.15.2
//$$		System.out.println("Only enabled in 1.15.2 and above");
		//# 1.14.4
		System.out.println("Only enabled in 1.14.4 and above");
		//# end
		
		
		////////////////////////////////////////
		// Def is always the lowest version: //
		///////////////////////////////////////
		
		//# 1.18.2
//$$		System.out.println("Only enabled in 1.18.2 and above");
		//# def
		System.out.println("Only enabled in 1.14.4 and above");
		//# end
		
		
		////////////////////////////////////////
		// 		Ordering is arbitrary! 		 //
		///////////////////////////////////////
		
		//# def
		System.out.println("Only enabled in 1.14.4 and above");
		//# 1.18.2
//$$		System.out.println("Only enabled in 1.18.2 and above");
		//# end
	}

}
