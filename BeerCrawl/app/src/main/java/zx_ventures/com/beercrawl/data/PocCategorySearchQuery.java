package zx_ventures.com.beercrawl.data;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Double;
import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class PocCategorySearchQuery implements Query<PocCategorySearchQuery.Data, PocCategorySearchQuery.Data, PocCategorySearchQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query pocCategorySearch($id: ID!, $search: String!, $categoryId: Int!) {\n"
      + "  poc(id: $id) {\n"
      + "    __typename\n"
      + "    products(categoryId: $categoryId, search: $search) {\n"
      + "      __typename\n"
      + "      productVariants {\n"
      + "        __typename\n"
      + "        title\n"
      + "        description\n"
      + "        imageUrl\n"
      + "        price\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "pocCategorySearch";
    }
  };

  private final PocCategorySearchQuery.Variables variables;

  public PocCategorySearchQuery(@Nonnull String id, @Nonnull String search, int categoryId) {
    Utils.checkNotNull(id, "id == null");
    Utils.checkNotNull(search, "search == null");
    variables = new PocCategorySearchQuery.Variables(id, search, categoryId);
  }

  @Override
  public String operationId() {
    return "55afd114fc087735ee0a31fa23083bc6cb3e8a6f1f9afbeeeba26d69b11ae94c";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public PocCategorySearchQuery.Data wrapData(PocCategorySearchQuery.Data data) {
    return data;
  }

  @Override
  public PocCategorySearchQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<PocCategorySearchQuery.Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String id;

    private final @Nonnull String search;

    private final int categoryId;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String id, @Nonnull String search, int categoryId) {
      this.id = id;
      this.search = search;
      this.categoryId = categoryId;
      this.valueMap.put("id", id);
      this.valueMap.put("search", search);
      this.valueMap.put("categoryId", categoryId);
    }

    public @Nonnull String id() {
      return id;
    }

    public @Nonnull String search() {
      return search;
    }

    public int categoryId() {
      return categoryId;
    }

    @Override
    public Map<String, Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          writer.writeString("id", id);
          writer.writeString("search", search);
          writer.writeInt("categoryId", categoryId);
        }
      };
    }
  }

  public static final class Builder {
    private @Nonnull String id;

    private @Nonnull String search;

    private int categoryId;

    Builder() {
    }

    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    public Builder search(@Nonnull String search) {
      this.search = search;
      return this;
    }

    public Builder categoryId(int categoryId) {
      this.categoryId = categoryId;
      return this;
    }

    public PocCategorySearchQuery build() {
      if (id == null) throw new IllegalStateException("id can't be null");
      if (search == null) throw new IllegalStateException("search can't be null");
      return new PocCategorySearchQuery(id, search, categoryId);
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("poc", "poc", new UnmodifiableMapBuilder<String, Object>(1)
        .put("id", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "id")
        .build())
      .build(), true)
    };

    final @Nullable Poc poc;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable Poc poc) {
      this.poc = poc;
    }

    public @Nullable Poc poc() {
      return this.poc;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], poc != null ? poc.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "poc=" + poc
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.poc == null) ? (that.poc == null) : this.poc.equals(that.poc));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (poc == null) ? 0 : poc.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Poc.Mapper pocFieldMapper = new Poc.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Poc poc = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Poc>() {
          @Override
          public Poc read(ResponseReader reader) {
            return pocFieldMapper.map(reader);
          }
        });
        return new Data(poc);
      }
    }
  }

  public static class Poc {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forObjectList("products", "products", new UnmodifiableMapBuilder<String, Object>(2)
        .put("search", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "search")
        .build())
        .put("categoryId", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "categoryId")
        .build())
      .build(), true)
    };

    final @Nonnull String __typename;

    final @Nullable List<Product> products;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Poc(@Nonnull String __typename, @Nullable List<Product> products) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      this.products = products;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable List<Product> products() {
      return this.products;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], products != null ? new ResponseWriter.ListWriter() {
            @Override
            public void write(ResponseWriter.ListItemWriter listItemWriter) {
              for (Product $item : products) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Poc{"
          + "__typename=" + __typename + ", "
          + "products=" + products
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Poc) {
        Poc that = (Poc) o;
        return this.__typename.equals(that.__typename)
         && ((this.products == null) ? (that.products == null) : this.products.equals(that.products));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= (products == null) ? 0 : products.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Poc> {
      final Product.Mapper productFieldMapper = new Product.Mapper();

      @Override
      public Poc map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<Product> products = reader.readList($responseFields[1], new ResponseReader.ListReader<Product>() {
          @Override
          public Product read(ResponseReader.ListItemReader reader) {
            return reader.readObject(new ResponseReader.ObjectReader<Product>() {
              @Override
              public Product read(ResponseReader reader) {
                return productFieldMapper.map(reader);
              }
            });
          }
        });
        return new Poc(__typename, products);
      }
    }
  }

  public static class Product {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forObjectList("productVariants", "productVariants", null, true)
    };

    final @Nonnull String __typename;

    final @Nullable List<ProductVariant> productVariants;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Product(@Nonnull String __typename, @Nullable List<ProductVariant> productVariants) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      this.productVariants = productVariants;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable List<ProductVariant> productVariants() {
      return this.productVariants;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], productVariants != null ? new ResponseWriter.ListWriter() {
            @Override
            public void write(ResponseWriter.ListItemWriter listItemWriter) {
              for (ProductVariant $item : productVariants) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Product{"
          + "__typename=" + __typename + ", "
          + "productVariants=" + productVariants
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Product) {
        Product that = (Product) o;
        return this.__typename.equals(that.__typename)
         && ((this.productVariants == null) ? (that.productVariants == null) : this.productVariants.equals(that.productVariants));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= (productVariants == null) ? 0 : productVariants.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Product> {
      final ProductVariant.Mapper productVariantFieldMapper = new ProductVariant.Mapper();

      @Override
      public Product map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<ProductVariant> productVariants = reader.readList($responseFields[1], new ResponseReader.ListReader<ProductVariant>() {
          @Override
          public ProductVariant read(ResponseReader.ListItemReader reader) {
            return reader.readObject(new ResponseReader.ObjectReader<ProductVariant>() {
              @Override
              public ProductVariant read(ResponseReader reader) {
                return productVariantFieldMapper.map(reader);
              }
            });
          }
        });
        return new Product(__typename, productVariants);
      }
    }
  }

  public static class ProductVariant {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forString("title", "title", null, false),
      ResponseField.forString("description", "description", null, true),
      ResponseField.forString("imageUrl", "imageUrl", null, true),
      ResponseField.forDouble("price", "price", null, true)
    };

    final @Nonnull String __typename;

    final @Nonnull String title;

    final @Nullable String description;

    final @Nullable String imageUrl;

    final @Nullable Double price;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ProductVariant(@Nonnull String __typename, @Nonnull String title,
        @Nullable String description, @Nullable String imageUrl, @Nullable Double price) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      if (title == null) {
        throw new NullPointerException("title can't be null");
      }
      this.title = title;
      this.description = description;
      this.imageUrl = imageUrl;
      this.price = price;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nonnull String title() {
      return this.title;
    }

    public @Nullable String description() {
      return this.description;
    }

    public @Nullable String imageUrl() {
      return this.imageUrl;
    }

    public @Nullable Double price() {
      return this.price;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], title);
          writer.writeString($responseFields[2], description);
          writer.writeString($responseFields[3], imageUrl);
          writer.writeDouble($responseFields[4], price);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ProductVariant{"
          + "__typename=" + __typename + ", "
          + "title=" + title + ", "
          + "description=" + description + ", "
          + "imageUrl=" + imageUrl + ", "
          + "price=" + price
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof ProductVariant) {
        ProductVariant that = (ProductVariant) o;
        return this.__typename.equals(that.__typename)
         && this.title.equals(that.title)
         && ((this.description == null) ? (that.description == null) : this.description.equals(that.description))
         && ((this.imageUrl == null) ? (that.imageUrl == null) : this.imageUrl.equals(that.imageUrl))
         && ((this.price == null) ? (that.price == null) : this.price.equals(that.price));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= title.hashCode();
        h *= 1000003;
        h ^= (description == null) ? 0 : description.hashCode();
        h *= 1000003;
        h ^= (imageUrl == null) ? 0 : imageUrl.hashCode();
        h *= 1000003;
        h ^= (price == null) ? 0 : price.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<ProductVariant> {
      @Override
      public ProductVariant map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String title = reader.readString($responseFields[1]);
        final String description = reader.readString($responseFields[2]);
        final String imageUrl = reader.readString($responseFields[3]);
        final Double price = reader.readDouble($responseFields[4]);
        return new ProductVariant(__typename, title, description, imageUrl, price);
      }
    }
  }
}
