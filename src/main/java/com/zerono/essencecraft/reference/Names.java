package com.zerono.essencecraft.reference;

public class Names
{
    public static final class Blocks
    {
        public static final String INERT_STONE = "inertStone";
        public static final String ORE = "ore";
        public static final String[] ORE_SUBYTPES = {"salt"};
        public static final String ORE_SALT = "oreSalt";
        public static final String BASIC_CENTRIFUGE = "basicCentrifuge";
        public static final String DRIP_FILTER = "dripFilter";
        public static final String LARGE_DECANTER = "largeDecanter";
        public static final String LARGE_DECANTER_INVERTED = "largeDecanterInverted";
        public static final String FILTER_HOUSING = "filterHousing";
        public static final String FILTER_HOUSING_TOP = "filterHousingTop";
        public static final String FILTER_HOUSING_BOTTOM = "filterHousingBottom";
        public static final String FILTER_HOUSING_BOTH = "filterHousingBoth";
    }
    
    public static final class Items
    {
        public static final String ENDER_PEARL_DUST = "dustEnderPearl";
        public static final String INERT_PEARL = "inertPearl";
        public static final String INERT_DUST = "inertDust";
        public static final String FILTER_CLOTH = "filter.cloth";
        public static final String FILTER = "filter";
        public static final String[] FILTER_SUBTYPES = {"basic", "fine", "coal", "sturdy"};
        public static final String FILTER_BASIC = "filter.basic";
        public static final String FILTER_FINE = "filter.fine";
        public static final String FILTER_COAL = "filter.coal";
        public static final String FILTER_STURDY = "filter.sturdy";
        public static final String FILTER_FRAME = "filter.frame";
        public static final String COAL_DUST = "dustCoal";
        public static final String SALT_PILE = "saltPile";
        public static final String FILTER_HOUSING = "filter.housing";

        public static final String SOLUTION = "solution";
        public static final String REDSTONE_SOLUTION = "solutionRedstone";
        public static final String GLOWSTONE_SOLUTION = "solutionGlowstone";
        public static final String ENDER_SOLUTION = "solutionEnder";
        public static final String WITHER_SOLUTION = "solutionWither";
        public static final String GHAST_SOLUTION = "solutionGhast";
        
        public static final String[] SOLUTION_TYPES = {"saline", "redstone", "glowstone", "ender", "wither", "ghast"};
        public static final String[] ESSENCE_TYPES = {"redstone", "glowstone", "ender", "wither", "ghast"};
        public static final String[] SOLUTION_ESSENCE_SUBTYPES = {"unfiltered", "filtered", "purified", "pure", "charged"};
        
        
        public static final String ESSENCE = "essence";
        public static final String REDSTONE_ESSENCE = "essenceRedstone";
        public static final String GLOWSTONE_ESSENCE = "essenceGlowstone";
        public static final String ENDER_ESSENCE = "essenceEnder";
        public static final String WITHER_ESSENCE = "essenceWither";
        public static final String GHAST_ESSENCE = "essenceGhast";
        
    }
    
    public static final class Tools
    {
        
    }
    
    public static final class NBT
    {
        public static final String ITEMS = "Items";
        public static final String KNOWLEDGE = "Knowledge";
        public static final String CHARGE_LEVEL = "chargeLevel";
        public static final String MODE = "mode";
        public static final String CRAFTING_GUI_OPEN = "craftingGuiOpen";
        public static final String DRIP_FILTER_GUI_OPEN = "dripFilterGuiOpen";
        public static final String UUID_MOST_SIG = "UUIDMostSig";
        public static final String UUID_LEAST_SIG = "UUIDLeastSig";
        public static final String DISPLAY = "display";
        public static final String COLOR = "color";
        public static final String STATE = "teState";
        public static final String CUSTOM_NAME = "CustomName";
        public static final String DIRECTION = "teDirection";
        public static final String OWNER = "owner";
        public static final String OWNER_UUID_MOST_SIG = "ownerUUIDMostSig";
        public static final String OWNER_UUID_LEAST_SIG = "ownerUUIDLeastSig";
    }
    
    public static final class Containers
    {
    	public static final String VANILLA_INVENTORY = "container.inventory";
    	public static final String VANILLA_CRAFTING = "container.crafting";
    	public static final String DRIP_FILTER = "container.ec:" + Blocks.DRIP_FILTER;
    }
    
}
