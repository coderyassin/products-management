package org.yascode.products_management.util;

public class ApiPaths {
    public static class Product {
        public static final String API = "api/";
        public static final String VERSION = "v2/";
        public static final String PATH = API + VERSION;
        public static final String PRODUCTS = PATH + "products";
        public static final String ALL = "/all";
        public static final String PRODUCT_BY_ID = "/{id}";
        public static final String PRODUCTS_BY_CATEGORY = "/category/{id}";
        public static final String SEARCH = "/search";
    }

    public static class Category {
        public static final String API = "api/";
        public static final String VERSION = "v2/";
        public static final String PATH = API + VERSION;
        public static final String CATEGORIES = PATH + "categories";
        public static final String ALL = "/all";
        public static final String CATEGORY_BY_ID = "/{id}";
        public static final String SEARCH = "/search";
    }

    public static class Auth {
        public static final String API = "api/";
        public static final String VERSION = "v2/";
        public static final String PATH = API + VERSION;
        public static final String AUTH = PATH + "auth";
    }
}
