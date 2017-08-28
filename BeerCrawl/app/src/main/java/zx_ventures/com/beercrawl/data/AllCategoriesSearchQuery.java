package zx_ventures.com.beercrawl.data;

import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class AllCategoriesSearchQuery implements Query<AllCategoriesSearchQuery.Data, AllCategoriesSearchQuery.Data, Operation.Variables> {
  public static final String OPERATION_DEFINITION = "query allCategoriesSearch {\n"
      + "  allCategory {\n"
      + "    __typename\n"
      + "    title\n"
      + "    id\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "allCategoriesSearch";
    }
  };

  private final Operation.Variables variables;

  public AllCategoriesSearchQuery() {
    this.variables = Operation.EMPTY_VARIABLES;
  }

  @Override
  public String operationId() {
    return "a13b6b71cb00e240dcc702af2a24a8690f6914f37a4a849aae8eca02de3141d7";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public AllCategoriesSearchQuery.Data wrapData(AllCategoriesSearchQuery.Data data) {
    return data;
  }

  @Override
  public Operation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<AllCategoriesSearchQuery.Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  public static final class Builder {
    Builder() {
    }

    public AllCategoriesSearchQuery build() {
      return new AllCategoriesSearchQuery();
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObjectList("allCategory", "allCategory", null, true)
    };

    final @Nullable List<AllCategory> allCategory;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable List<AllCategory> allCategory) {
      this.allCategory = allCategory;
    }

    public @Nullable List<AllCategory> allCategory() {
      return this.allCategory;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeList($responseFields[0], allCategory != null ? new ResponseWriter.ListWriter() {
            @Override
            public void write(ResponseWriter.ListItemWriter listItemWriter) {
              for (AllCategory $item : allCategory) {
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
        $toString = "Data{"
          + "allCategory=" + allCategory
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
        return ((this.allCategory == null) ? (that.allCategory == null) : this.allCategory.equals(that.allCategory));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (allCategory == null) ? 0 : allCategory.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final AllCategory.Mapper allCategoryFieldMapper = new AllCategory.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final List<AllCategory> allCategory = reader.readList($responseFields[0], new ResponseReader.ListReader<AllCategory>() {
          @Override
          public AllCategory read(ResponseReader.ListItemReader reader) {
            return reader.readObject(new ResponseReader.ObjectReader<AllCategory>() {
              @Override
              public AllCategory read(ResponseReader reader) {
                return allCategoryFieldMapper.map(reader);
              }
            });
          }
        });
        return new Data(allCategory);
      }
    }
  }

  public static class AllCategory {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forString("title", "title", null, true),
      ResponseField.forString("id", "id", null, true)
    };

    final @Nonnull String __typename;

    final @Nullable String title;

    final @Nullable String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public AllCategory(@Nonnull String __typename, @Nullable String title, @Nullable String id) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      this.title = title;
      this.id = id;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable String title() {
      return this.title;
    }

    public @Nullable String id() {
      return this.id;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], title);
          writer.writeString($responseFields[2], id);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "AllCategory{"
          + "__typename=" + __typename + ", "
          + "title=" + title + ", "
          + "id=" + id
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof AllCategory) {
        AllCategory that = (AllCategory) o;
        return this.__typename.equals(that.__typename)
         && ((this.title == null) ? (that.title == null) : this.title.equals(that.title))
         && ((this.id == null) ? (that.id == null) : this.id.equals(that.id));
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
        h ^= (title == null) ? 0 : title.hashCode();
        h *= 1000003;
        h ^= (id == null) ? 0 : id.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<AllCategory> {
      @Override
      public AllCategory map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String title = reader.readString($responseFields[1]);
        final String id = reader.readString($responseFields[2]);
        return new AllCategory(__typename, title, id);
      }
    }
  }
}
