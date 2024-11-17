/*    */ package net.nastynate.sandworm_mod.config;
/*    */ 
/*    */ import net.minecraftforge.common.ForgeConfigSpec;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommonConfigs
/*    */ {
/* 12 */   public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final ForgeConfigSpec SPEC;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static {
/* 24 */     BUILDER.push("Desert Behemoths: Sandworms! Config");
/*    */   }
/* 26 */   public static final ForgeConfigSpec.ConfigValue<Integer> SPAWNWORM_WORMSIGN = (ForgeConfigSpec.ConfigValue<Integer>)BUILDER.comment("Value at which sandworm will spawn. Higher values mean the worm will take longer to spawn. Default 4000.")
/* 27 */     .defineInRange("Max Wormsign", 4000, 1000, 100000);
/*    */   public static final ForgeConfigSpec.ConfigValue<Integer> HEALTH;
/* 29 */   public static final ForgeConfigSpec.ConfigValue<Integer> RESPAWN_DURATION = (ForgeConfigSpec.ConfigValue<Integer>)BUILDER.comment("Seconds after leaving a worm's range until another one can spawn. Default 120.")
/* 30 */     .defineInRange("Respawn Duration", 120, 10, 216000);
/*    */   
/* 32 */   public static final ForgeConfigSpec.ConfigValue<Integer> DESPAWN_TIMER = (ForgeConfigSpec.ConfigValue<Integer>)BUILDER.comment("Time til despawn in seconds when not targeting a survival player. Default 3 minutes.")
/* 33 */     .defineInRange("Despawn Duration", 180, 30, 216000); public static final ForgeConfigSpec.ConfigValue<Double> DAMAGE_SCALE;
/*    */   
/*    */   static {
/* 36 */     HEALTH = (ForgeConfigSpec.ConfigValue<Integer>)BUILDER.comment("Number of explosions the worm's head can handle before dropping a tooth and running away. Default 3").defineInRange("Health", 3, 1, 100);
/*    */ 
/*    */     
/* 39 */     DAMAGE_SCALE = (ForgeConfigSpec.ConfigValue<Double>)BUILDER.comment("Value the damage dealt by the worm is scaled by. Default 1.0.").defineInRange("Damage Multiplier", 1.0D, 0.01D, 100.0D);
/*    */ 
/*    */     
/* 42 */     HEAD_MULTIPLIER = (ForgeConfigSpec.ConfigValue<Double>)BUILDER.comment("Multiplier for damage dealt by the head of the worm compared to a body segment. Default 2.0 (head deals double damage).").defineInRange("Head Multiplier", 2.0D, 0.01D, 100.0D);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 53 */     DEFAULT_SPAWNING = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.comment("By default, the sandworm can spawn in any biome golden rabbits spawn in. This option enables or disables that.\nTo add additional biomes the sandworm can spawn in, create a datapack that edits the sandworm_mod:can_spawn_sandworms biome tag.\nSpecifically, create can_spawn_sandworms.json in data->sandworm_mod->tags->worldgen->biome.\nBellow is an example json file that allows sandworms to spawn in jungles:\n{\n  \"values\": [\n    \"minecraft:jungle\"\n  ]\n}").define("Default Spawning", true);
/*    */     
/* 55 */     BUILDER.pop();
/* 56 */     SPEC = BUILDER.build();
/*    */   }
/*    */   
/*    */   public static final ForgeConfigSpec.ConfigValue<Double> HEAD_MULTIPLIER;
/*    */   public static final ForgeConfigSpec.ConfigValue<Boolean> DEFAULT_SPAWNING;
/*    */ }


/* Location:              C:\Users\Nathen Williams\Downloads\sandworm_mod-1.1.1.jar!\net\jelly\sandworm_mod\config\CommonConfigs.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */