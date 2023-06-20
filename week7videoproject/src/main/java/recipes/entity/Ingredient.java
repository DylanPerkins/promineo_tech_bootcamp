package recipes.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Ingredient extends EntityBase{

    private Integer ingredientId;
    private Integer recipeId;
    private Unit unit;
    private String ingredientName;
    private String instruction;
    private Integer ingredientOrder;
    private BigDecimal amount;

    // toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ingredientId=").append(ingredientId).append(": ");
        sb.append(toFraction(amount));
        
        if (Objects.nonNull(unit) && Objects.nonNull(unit.getUnitId())) {
            String singular = unit.getUnitNameSingular();
            String plural = unit.getUnitNamePlural();
            String word = amount.compareTo(BigDecimal.ONE) > 0 ? plural : singular;

            sb.append(word).append(" ");
        }

        sb.append(ingredientName);

        if (Objects.nonNull(instruction)) {
            sb.append(", ").append(instruction);
        }

        return sb.toString();
    }

    // Getters and Setters

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unitId) {
        this.unit = unitId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientNameId) {
        this.ingredientName = ingredientNameId;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instructionId) {
        this.instruction = instructionId;
    }

    public Integer getIngredientOrder() {
        return ingredientOrder;
    }

    public void setIngredientOrder(Integer ingredientOrder) {
        this.ingredientOrder = ingredientOrder;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amountId) {
        this.amount = amountId;
    }

}
