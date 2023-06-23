package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.data.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient>{
	private IngredientRepository ingredientRepo;
	@Autowired
	public IngredientByIdConverter(IngredientRepository ingredientRepo) {
		this.ingredientRepo  = ingredientRepo;
	}
	public Ingredient convert(String id) {
		return ingredientRepo.findById(id).orElse(null);
	}
}
