package service;

import model.Category;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zamuna on 6/18/2017.
 */
public class CategoryService extends AbstractService<Category> implements IService<Category>{
    private static final List<String> searchFields = Arrays.asList("name");
    public CategoryService(Class<Category> clazz) {
        super(clazz);
    }

    public static void main(String[] args) {
        CategoryService categoryService=new CategoryService(Category.class);
        Category category=new Category();
        category.setName("Books");
        category.setDescription("This is book category");

        Map<String, String> map = new HashMap<>();
        String token = "ac59789228894429a678be5f4e2e6a85";
        map.put("Authorization", "Bearer "+token);
        categoryService.setMap(map);

        categoryService.insert(category);
//        category.setName("Book");
//        category=categoryService.updateCategory(category, 1l);
//        System.out.println(category);
        Long id=5l;
//        categoryService.getCategory(6l);

    }

    @Override
    public Object insert(Category category) {
        System.out.println("Category : "+category);
        Object category1 = post(null, category, Category.class);
        return category1;
    }

    @Override
    public Object update(Category category, String id) {
        System.out.println("Update Category");
        Object category1=put(id.toString(),category);
        return category1;
    }

    @Override
    public Category get(String id) {
        Category category1= getById(id);
        return category1;
    }

    @Override
    public List<Category> getAllData(String url, String searchText, Integer offset, Integer limit) {
        return getAll(url, searchText, offset, limit);
    }
}
