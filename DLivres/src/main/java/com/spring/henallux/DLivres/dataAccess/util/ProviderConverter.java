package com.spring.henallux.DLivres.dataAccess.util;

import com.spring.henallux.DLivres.Model.*;
import com.spring.henallux.DLivres.dataAccess.entity.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ProviderConverter {
    private Mapper mapper = new DozerBeanMapper();

    public AuthorEntity authorToAuthorEntity(Author author) {
        return mapper.map(author, AuthorEntity.class);
    }

    public Author authorEntityToAuthor(AuthorEntity authorEntity) {
        return mapper.map(authorEntity, Author.class);
    }

    public BookEntity bookToBookEntity(Book book) {
        return mapper.map(book, BookEntity.class);
    }

    public Book bookEntityToBook(BookEntity bookEntity) {
        return mapper.map(bookEntity, Book.class);
    }

    public CategoryEntity categoryToCategoryEntity(Category category) {
        return mapper.map(category, CategoryEntity.class);
    }

    public Category categoryEntityToCategory(CategoryEntity categoryEntity) {
        return mapper.map(categoryEntity, Category.class);
    }

    public CommandLineEntity commandLineToCommandLineEntity(CommandLine commandLine) {
        return mapper.map(commandLine, CommandLineEntity.class);
    }

    public CommandLine commandLineEntityToCommandLine(CommandLineEntity commandLineEntity) {
        return mapper.map(commandLineEntity, CommandLine.class);
    }

    public CurrentLanguageEntity currentLanguageToCurrentLanguageEntity(CurrentLanguage currentLanguage) {
        return mapper.map(currentLanguage, CurrentLanguageEntity.class);
    }

    public CurrentLanguage currentLanguageEntityToCurrentLanguage(CurrentLanguageEntity currentLanguageEntity) {
        return mapper.map(currentLanguageEntity, CurrentLanguage.class);
    }

    public CustomerEntity customerToCustomerEntity(Customer customer)
    {
        return mapper.map(customer,CustomerEntity.class);
    }

    public Customer customerEntityToCustomer(CustomerEntity customerEntity)
    {
        return mapper.map(customerEntity,Customer.class);
    }

    public LanguageTranslationTitleOfBookEntity languageTranslationTitleOfBookToLanguageTranslationTitleOfBookEntity(LanguageTranslationTitleOfBook languageTranslationTitleOfBook)
    {
        return mapper.map(languageTranslationTitleOfBook,LanguageTranslationTitleOfBookEntity.class);
    }

    public LanguageTranslationTitleOfBook languageTranslationTitleOfBookEntityToLanguageTranslationTitleOfBook(LanguageTranslationTitleOfBookEntity languageTranslationTitleOfBookEntity)
    {
        return mapper.map(languageTranslationTitleOfBookEntity,LanguageTranslationTitleOfBook.class);
    }

    public LanguageTranslationWordingOfCategoryEntity languageTranslationWordingOfCategoryToLanguageTranslationWordingOfCategoryEntity(LanguageTranslationWordingOfCategory languageTranslationWordingOfCategory )
    {
        return mapper.map(languageTranslationWordingOfCategory,LanguageTranslationWordingOfCategoryEntity.class);
    }

    public LanguageTranslationWordingOfCategory languageTranslationWordingOfCategoryEntityToLanguageTranslationWordingOfCategory(LanguageTranslationWordingOfCategoryEntity languageTranslationWordingOfCategoryEntity )
    {
        LanguageTranslationWordingOfCategory languageTranslationWordingOfCategory = new LanguageTranslationWordingOfCategory();
        languageTranslationWordingOfCategory.setLanguageTranslationWordingOfCategory_id(languageTranslationWordingOfCategoryEntity.getLanguageTranslationWordingOfCategory_id());
        languageTranslationWordingOfCategory.setTranslationWordingOfCategory(languageTranslationWordingOfCategoryEntity.getTranslationWordingOfCategory());
        languageTranslationWordingOfCategory.setCategory_id(categoryEntityToCategory(languageTranslationWordingOfCategoryEntity.getCategory_id()));
        languageTranslationWordingOfCategory.setCurrentLanguageId(currentLanguageEntityToCurrentLanguage(languageTranslationWordingOfCategoryEntity.getCurrentLanguageId()));

        return languageTranslationWordingOfCategory;
    }

    public OrderCustomerEntity orderCustomerToOrderCustomerEntity(OrderCustomer orderCustomer)
    {
        return mapper.map(orderCustomer,OrderCustomerEntity.class);
    }

    public OrderCustomer orderCustomerEntityToOrderCustomer(OrderCustomerEntity orderCustomerEntity)
    {
        return mapper.map(orderCustomerEntity,OrderCustomer.class);
    }

    public PublishingHouseEntity publishingHouseToPublishingHouseEntity(PublishingHouse publishingHouse)
    {
        return mapper.map(publishingHouse,PublishingHouseEntity.class);
    }
    public PublishingHouse publishingHouseEntityToPublishingHous(PublishingHouseEntity publishingHouseEntity)
    {
        return mapper.map(publishingHouseEntity,PublishingHouse.class);
    }
}
