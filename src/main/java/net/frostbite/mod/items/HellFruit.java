package net.frostbite.mod.items;

import net.minecraft.item.ItemFood;

public class HellFruit extends ItemFood {

	public HellFruit(int heal, float satruration, boolean wolfmeat) {
		super(heal, satruration, wolfmeat);
		
		
		
		this.setPotionEffect(12, 120, 1, 1F);
	}

}
