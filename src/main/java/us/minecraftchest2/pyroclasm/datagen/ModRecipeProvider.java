package us.minecraftchest2.pyroclasm.datagen;

import net.minecraft.world.item.Items;
import us.minecraftchest2.pyroclasm.Pyroclasm;
import us.minecraftchest2.pyroclasm.block.ModBlocks;
import us.minecraftchest2.pyroclasm.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> CORE_IRON_SMELTABLES = List.of(ModItems.RAW_CORE_IRON.get(),
            ModItems.RAW_CORE_IRON.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, CORE_IRON_SMELTABLES, RecipeCategory.MISC,
                 ModItems.CORE_IRON.get(), 0.25f, 100, "core_iron");
        oreSmelting(pWriter, CORE_IRON_SMELTABLES, RecipeCategory.MISC,
                ModItems.CORE_IRON.get(), 0.25f, 200, "core_iron");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORE_IRON.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.CORE_IRON.get())
                .unlockedBy("has_item", has(ModItems.CORE_IRON.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CORE_IRON.get(),9)
                .requires(ModBlocks.CORE_IRON_BLOCK.get())
                .unlockedBy("has_item", has(ModBlocks.CORE_IRON_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  Pyroclasm.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}