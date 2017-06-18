package service;

import model.Category;
import model.Category;

import java.util.List;

/**
 * Created by Zamuna on 6/18/2017.
 */
public class CategoryService extends AbstractService<Category> {

    public CategoryService(Class<Category> clazz) {
        super(clazz);
    }

    public Category insertCategory(Category category){
        System.out.println("Category : "+category);
        Category category1 = post(null, category);
        return category1;
    }

    public Category updateCategory(Category category, Long id){
        System.out.println("Update Category");
        Category category1=put(id.toString(),category);
        return category1;
    }

    public Category getCategory(Long category){
        Category category1=get(category.toString(),category);
        return category1;
    }
    public List<Category> getAllCategory(){
//        List<Category> categorys=getAll(null)
        return null;
    }

    public static void main(String[] args) {
        CategoryService categoryService=new CategoryService(Category.class);
        Category category=new Category();
        category.setName("Books");
        category.setDescription("This is book category");
        categoryService.insertCategory(category);
//        category.setName("Book");
//        category=categoryService.updateCategory(category, 1l);
//        System.out.println(category);
        Long id=5l;
//        categoryService.getCategory(6l);

    }
}
