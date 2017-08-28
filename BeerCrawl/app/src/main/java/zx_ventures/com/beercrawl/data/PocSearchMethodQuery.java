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
import java.lang.Boolean;
import java.lang.Double;
import java.lang.IllegalStateException;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import type.CustomType;
import type.Status;

@Generated("Apollo GraphQL")
public final class PocSearchMethodQuery implements Query<PocSearchMethodQuery.Data, PocSearchMethodQuery.Data, PocSearchMethodQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query pocSearchMethod($now: DateTime!, $algorithm: String!, $lat: String!, $lng: String!) {\n"
      + "  pocSearch(now: $now, algorithm: $algorithm, lat: $lat, long: $lng) {\n"
      + "    __typename\n"
      + "    __typename\n"
      + "    id\n"
      + "    status\n"
      + "    tradingName\n"
      + "    officialName\n"
      + "    deliveryTypes {\n"
      + "      __typename\n"
      + "      __typename\n"
      + "      pocDeliveryTypeId\n"
      + "      deliveryTypeId\n"
      + "      price\n"
      + "      title\n"
      + "      subtitle\n"
      + "      active\n"
      + "    }\n"
      + "    paymentMethods {\n"
      + "      __typename\n"
      + "      __typename\n"
      + "      pocPaymentMethodId\n"
      + "      paymentMethodId\n"
      + "      active\n"
      + "      title\n"
      + "      subtitle\n"
      + "    }\n"
      + "    pocWorkDay {\n"
      + "      __typename\n"
      + "      __typename\n"
      + "      weekDay\n"
      + "      active\n"
      + "      workingInterval {\n"
      + "        __typename\n"
      + "        __typename\n"
      + "        openingTime\n"
      + "        closingTime\n"
      + "      }\n"
      + "    }\n"
      + "    address {\n"
      + "      __typename\n"
      + "      __typename\n"
      + "      address1\n"
      + "      address2\n"
      + "      number\n"
      + "      city\n"
      + "      province\n"
      + "      zip\n"
      + "      coordinates\n"
      + "    }\n"
      + "    phone {\n"
      + "      __typename\n"
      + "      __typename\n"
      + "      phoneNumber\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "pocSearchMethod";
    }
  };

  private final PocSearchMethodQuery.Variables variables;

  public PocSearchMethodQuery(@Nonnull Object now, @Nonnull String algorithm, @Nonnull String lat,
      @Nonnull String lng) {
    Utils.checkNotNull(now, "now == null");
    Utils.checkNotNull(algorithm, "algorithm == null");
    Utils.checkNotNull(lat, "lat == null");
    Utils.checkNotNull(lng, "lng == null");
    variables = new PocSearchMethodQuery.Variables(now, algorithm, lat, lng);
  }

  @Override
  public String operationId() {
    return "88e5596658bb464687afe8a7fddc74e0e3a58fa0ebdc8d699ff042cfdff92b47";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public PocSearchMethodQuery.Data wrapData(PocSearchMethodQuery.Data data) {
    return data;
  }

  @Override
  public PocSearchMethodQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<PocSearchMethodQuery.Data> responseFieldMapper() {
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
    private final @Nonnull Object now;

    private final @Nonnull String algorithm;

    private final @Nonnull String lat;

    private final @Nonnull String lng;

    private final transient Map<String, java.lang.Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull Object now, @Nonnull String algorithm, @Nonnull String lat,
        @Nonnull String lng) {
      this.now = now;
      this.algorithm = algorithm;
      this.lat = lat;
      this.lng = lng;
      this.valueMap.put("now", now);
      this.valueMap.put("algorithm", algorithm);
      this.valueMap.put("lat", lat);
      this.valueMap.put("lng", lng);
    }

    public @Nonnull Object now() {
      return now;
    }

    public @Nonnull String algorithm() {
      return algorithm;
    }

    public @Nonnull String lat() {
      return lat;
    }

    public @Nonnull String lng() {
      return lng;
    }

    @Override
    public Map<String, java.lang.Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          writer.writeCustom("now", type.CustomType.DATETIME, now);
          writer.writeString("algorithm", algorithm);
          writer.writeString("lat", lat);
          writer.writeString("lng", lng);
        }
      };
    }
  }

  public static final class Builder {
    private @Nonnull Object now;

    private @Nonnull String algorithm;

    private @Nonnull String lat;

    private @Nonnull String lng;

    Builder() {
    }

    public Builder now(@Nonnull Object now) {
      this.now = now;
      return this;
    }

    public Builder algorithm(@Nonnull String algorithm) {
      this.algorithm = algorithm;
      return this;
    }

    public Builder lat(@Nonnull String lat) {
      this.lat = lat;
      return this;
    }

    public Builder lng(@Nonnull String lng) {
      this.lng = lng;
      return this;
    }

    public PocSearchMethodQuery build() {
      if (now == null) throw new IllegalStateException("now can't be null");
      if (algorithm == null) throw new IllegalStateException("algorithm can't be null");
      if (lat == null) throw new IllegalStateException("lat can't be null");
      if (lng == null) throw new IllegalStateException("lng can't be null");
      return new PocSearchMethodQuery(now, algorithm, lat, lng);
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObjectList("pocSearch", "pocSearch", new UnmodifiableMapBuilder<String, java.lang.Object>(4)
        .put("now", new UnmodifiableMapBuilder<String, java.lang.Object>(2)
          .put("kind", "Variable")
          .put("variableName", "now")
        .build())
        .put("lat", new UnmodifiableMapBuilder<String, java.lang.Object>(2)
          .put("kind", "Variable")
          .put("variableName", "lat")
        .build())
        .put("long", new UnmodifiableMapBuilder<String, java.lang.Object>(2)
          .put("kind", "Variable")
          .put("variableName", "lng")
        .build())
        .put("algorithm", new UnmodifiableMapBuilder<String, java.lang.Object>(2)
          .put("kind", "Variable")
          .put("variableName", "algorithm")
        .build())
      .build(), true)
    };

    final @Nullable List<PocSearch> pocSearch;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable List<PocSearch> pocSearch) {
      this.pocSearch = pocSearch;
    }

    public @Nullable List<PocSearch> pocSearch() {
      return this.pocSearch;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeList($responseFields[0], pocSearch != null ? new ResponseWriter.ListWriter() {
            @Override
            public void write(ResponseWriter.ListItemWriter listItemWriter) {
              for (PocSearch $item : pocSearch) {
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
          + "pocSearch=" + pocSearch
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(java.lang.Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.pocSearch == null) ? (that.pocSearch == null) : this.pocSearch.equals(that.pocSearch));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (pocSearch == null) ? 0 : pocSearch.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final PocSearch.Mapper pocSearchFieldMapper = new PocSearch.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final List<PocSearch> pocSearch = reader.readList($responseFields[0], new ResponseReader.ListReader<PocSearch>() {
          @Override
          public PocSearch read(ResponseReader.ListItemReader reader) {
            return reader.readObject(new ResponseReader.ObjectReader<PocSearch>() {
              @Override
              public PocSearch read(ResponseReader reader) {
                return pocSearchFieldMapper.map(reader);
              }
            });
          }
        });
        return new Data(pocSearch);
      }
    }
  }

  public static class PocSearch {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forString("id", "id", null, true),
      ResponseField.forString("status", "status", null, false),
      ResponseField.forString("tradingName", "tradingName", null, true),
      ResponseField.forString("officialName", "officialName", null, true),
      ResponseField.forObjectList("deliveryTypes", "deliveryTypes", null, true),
      ResponseField.forObjectList("paymentMethods", "paymentMethods", null, true),
      ResponseField.forObjectList("pocWorkDay", "pocWorkDay", null, true),
      ResponseField.forObject("address", "address", null, true),
      ResponseField.forObject("phone", "phone", null, true)
    };

    final @Nonnull String __typename;

    final @Nullable String id;

    final @Nonnull Status status;

    final @Nullable String tradingName;

    final @Nullable String officialName;

    final @Nullable List<DeliveryType> deliveryTypes;

    final @Nullable List<PaymentMethod> paymentMethods;

    final @Nullable List<PocWorkDay> pocWorkDay;

    final @Nullable Address address;

    final @Nullable Phone phone;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PocSearch(@Nonnull String __typename, @Nullable String id, @Nonnull Status status,
        @Nullable String tradingName, @Nullable String officialName,
        @Nullable List<DeliveryType> deliveryTypes, @Nullable List<PaymentMethod> paymentMethods,
        @Nullable List<PocWorkDay> pocWorkDay, @Nullable Address address, @Nullable Phone phone) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      this.id = id;
      if (status == null) {
        throw new NullPointerException("status can't be null");
      }
      this.status = status;
      this.tradingName = tradingName;
      this.officialName = officialName;
      this.deliveryTypes = deliveryTypes;
      this.paymentMethods = paymentMethods;
      this.pocWorkDay = pocWorkDay;
      this.address = address;
      this.phone = phone;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable String id() {
      return this.id;
    }

    public @Nonnull Status status() {
      return this.status;
    }

    public @Nullable String tradingName() {
      return this.tradingName;
    }

    public @Nullable String officialName() {
      return this.officialName;
    }

    public @Nullable List<DeliveryType> deliveryTypes() {
      return this.deliveryTypes;
    }

    public @Nullable List<PaymentMethod> paymentMethods() {
      return this.paymentMethods;
    }

    public @Nullable List<PocWorkDay> pocWorkDay() {
      return this.pocWorkDay;
    }

    public @Nullable Address address() {
      return this.address;
    }

    public @Nullable Phone phone() {
      return this.phone;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], id);
          writer.writeString($responseFields[2], status.name());
          writer.writeString($responseFields[3], tradingName);
          writer.writeString($responseFields[4], officialName);
          writer.writeList($responseFields[5], deliveryTypes != null ? new ResponseWriter.ListWriter() {
            @Override
            public void write(ResponseWriter.ListItemWriter listItemWriter) {
              for (DeliveryType $item : deliveryTypes) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
          writer.writeList($responseFields[6], paymentMethods != null ? new ResponseWriter.ListWriter() {
            @Override
            public void write(ResponseWriter.ListItemWriter listItemWriter) {
              for (PaymentMethod $item : paymentMethods) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
          writer.writeList($responseFields[7], pocWorkDay != null ? new ResponseWriter.ListWriter() {
            @Override
            public void write(ResponseWriter.ListItemWriter listItemWriter) {
              for (PocWorkDay $item : pocWorkDay) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
          writer.writeObject($responseFields[8], address != null ? address.marshaller() : null);
          writer.writeObject($responseFields[9], phone != null ? phone.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PocSearch{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "status=" + status + ", "
          + "tradingName=" + tradingName + ", "
          + "officialName=" + officialName + ", "
          + "deliveryTypes=" + deliveryTypes + ", "
          + "paymentMethods=" + paymentMethods + ", "
          + "pocWorkDay=" + pocWorkDay + ", "
          + "address=" + address + ", "
          + "phone=" + phone
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(java.lang.Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof PocSearch) {
        PocSearch that = (PocSearch) o;
        return this.__typename.equals(that.__typename)
         && ((this.id == null) ? (that.id == null) : this.id.equals(that.id))
         && this.status.equals(that.status)
         && ((this.tradingName == null) ? (that.tradingName == null) : this.tradingName.equals(that.tradingName))
         && ((this.officialName == null) ? (that.officialName == null) : this.officialName.equals(that.officialName))
         && ((this.deliveryTypes == null) ? (that.deliveryTypes == null) : this.deliveryTypes.equals(that.deliveryTypes))
         && ((this.paymentMethods == null) ? (that.paymentMethods == null) : this.paymentMethods.equals(that.paymentMethods))
         && ((this.pocWorkDay == null) ? (that.pocWorkDay == null) : this.pocWorkDay.equals(that.pocWorkDay))
         && ((this.address == null) ? (that.address == null) : this.address.equals(that.address))
         && ((this.phone == null) ? (that.phone == null) : this.phone.equals(that.phone));
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
        h ^= (id == null) ? 0 : id.hashCode();
        h *= 1000003;
        h ^= status.hashCode();
        h *= 1000003;
        h ^= (tradingName == null) ? 0 : tradingName.hashCode();
        h *= 1000003;
        h ^= (officialName == null) ? 0 : officialName.hashCode();
        h *= 1000003;
        h ^= (deliveryTypes == null) ? 0 : deliveryTypes.hashCode();
        h *= 1000003;
        h ^= (paymentMethods == null) ? 0 : paymentMethods.hashCode();
        h *= 1000003;
        h ^= (pocWorkDay == null) ? 0 : pocWorkDay.hashCode();
        h *= 1000003;
        h ^= (address == null) ? 0 : address.hashCode();
        h *= 1000003;
        h ^= (phone == null) ? 0 : phone.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<PocSearch> {
      final DeliveryType.Mapper deliveryTypeFieldMapper = new DeliveryType.Mapper();

      final PaymentMethod.Mapper paymentMethodFieldMapper = new PaymentMethod.Mapper();

      final PocWorkDay.Mapper pocWorkDayFieldMapper = new PocWorkDay.Mapper();

      final Address.Mapper addressFieldMapper = new Address.Mapper();

      final Phone.Mapper phoneFieldMapper = new Phone.Mapper();

      @Override
      public PocSearch map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readString($responseFields[1]);
        final String statusStr = reader.readString($responseFields[2]);
        final Status status;
        if (statusStr != null) {
          status = Status.valueOf(statusStr);
        } else {
          status = null;
        }
        final String tradingName = reader.readString($responseFields[3]);
        final String officialName = reader.readString($responseFields[4]);
        final List<DeliveryType> deliveryTypes = reader.readList($responseFields[5], new ResponseReader.ListReader<DeliveryType>() {
          @Override
          public DeliveryType read(ResponseReader.ListItemReader reader) {
            return reader.readObject(new ResponseReader.ObjectReader<DeliveryType>() {
              @Override
              public DeliveryType read(ResponseReader reader) {
                return deliveryTypeFieldMapper.map(reader);
              }
            });
          }
        });
        final List<PaymentMethod> paymentMethods = reader.readList($responseFields[6], new ResponseReader.ListReader<PaymentMethod>() {
          @Override
          public PaymentMethod read(ResponseReader.ListItemReader reader) {
            return reader.readObject(new ResponseReader.ObjectReader<PaymentMethod>() {
              @Override
              public PaymentMethod read(ResponseReader reader) {
                return paymentMethodFieldMapper.map(reader);
              }
            });
          }
        });
        final List<PocWorkDay> pocWorkDay = reader.readList($responseFields[7], new ResponseReader.ListReader<PocWorkDay>() {
          @Override
          public PocWorkDay read(ResponseReader.ListItemReader reader) {
            return reader.readObject(new ResponseReader.ObjectReader<PocWorkDay>() {
              @Override
              public PocWorkDay read(ResponseReader reader) {
                return pocWorkDayFieldMapper.map(reader);
              }
            });
          }
        });
        final Address address = reader.readObject($responseFields[8], new ResponseReader.ObjectReader<Address>() {
          @Override
          public Address read(ResponseReader reader) {
            return addressFieldMapper.map(reader);
          }
        });
        final Phone phone = reader.readObject($responseFields[9], new ResponseReader.ObjectReader<Phone>() {
          @Override
          public Phone read(ResponseReader reader) {
            return phoneFieldMapper.map(reader);
          }
        });
        return new PocSearch(__typename, id, status, tradingName, officialName, deliveryTypes, paymentMethods, pocWorkDay, address, phone);
      }
    }
  }

  public static class DeliveryType {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forString("pocDeliveryTypeId", "pocDeliveryTypeId", null, false),
      ResponseField.forString("deliveryTypeId", "deliveryTypeId", null, false),
      ResponseField.forDouble("price", "price", null, true),
      ResponseField.forString("title", "title", null, true),
      ResponseField.forString("subtitle", "subtitle", null, true),
      ResponseField.forBoolean("active", "active", null, true)
    };

    final @Nonnull String __typename;

    final @Nonnull String pocDeliveryTypeId;

    final @Nonnull String deliveryTypeId;

    final @Nullable Double price;

    final @Nullable String title;

    final @Nullable String subtitle;

    final @Nullable Boolean active;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public DeliveryType(@Nonnull String __typename, @Nonnull String pocDeliveryTypeId,
        @Nonnull String deliveryTypeId, @Nullable Double price, @Nullable String title,
        @Nullable String subtitle, @Nullable Boolean active) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      if (pocDeliveryTypeId == null) {
        throw new NullPointerException("pocDeliveryTypeId can't be null");
      }
      this.pocDeliveryTypeId = pocDeliveryTypeId;
      if (deliveryTypeId == null) {
        throw new NullPointerException("deliveryTypeId can't be null");
      }
      this.deliveryTypeId = deliveryTypeId;
      this.price = price;
      this.title = title;
      this.subtitle = subtitle;
      this.active = active;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nonnull String pocDeliveryTypeId() {
      return this.pocDeliveryTypeId;
    }

    public @Nonnull String deliveryTypeId() {
      return this.deliveryTypeId;
    }

    public @Nullable Double price() {
      return this.price;
    }

    public @Nullable String title() {
      return this.title;
    }

    public @Nullable String subtitle() {
      return this.subtitle;
    }

    public @Nullable Boolean active() {
      return this.active;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], pocDeliveryTypeId);
          writer.writeString($responseFields[2], deliveryTypeId);
          writer.writeDouble($responseFields[3], price);
          writer.writeString($responseFields[4], title);
          writer.writeString($responseFields[5], subtitle);
          writer.writeBoolean($responseFields[6], active);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "DeliveryType{"
          + "__typename=" + __typename + ", "
          + "pocDeliveryTypeId=" + pocDeliveryTypeId + ", "
          + "deliveryTypeId=" + deliveryTypeId + ", "
          + "price=" + price + ", "
          + "title=" + title + ", "
          + "subtitle=" + subtitle + ", "
          + "active=" + active
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(java.lang.Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof DeliveryType) {
        DeliveryType that = (DeliveryType) o;
        return this.__typename.equals(that.__typename)
         && this.pocDeliveryTypeId.equals(that.pocDeliveryTypeId)
         && this.deliveryTypeId.equals(that.deliveryTypeId)
         && ((this.price == null) ? (that.price == null) : this.price.equals(that.price))
         && ((this.title == null) ? (that.title == null) : this.title.equals(that.title))
         && ((this.subtitle == null) ? (that.subtitle == null) : this.subtitle.equals(that.subtitle))
         && ((this.active == null) ? (that.active == null) : this.active.equals(that.active));
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
        h ^= pocDeliveryTypeId.hashCode();
        h *= 1000003;
        h ^= deliveryTypeId.hashCode();
        h *= 1000003;
        h ^= (price == null) ? 0 : price.hashCode();
        h *= 1000003;
        h ^= (title == null) ? 0 : title.hashCode();
        h *= 1000003;
        h ^= (subtitle == null) ? 0 : subtitle.hashCode();
        h *= 1000003;
        h ^= (active == null) ? 0 : active.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<DeliveryType> {
      @Override
      public DeliveryType map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String pocDeliveryTypeId = reader.readString($responseFields[1]);
        final String deliveryTypeId = reader.readString($responseFields[2]);
        final Double price = reader.readDouble($responseFields[3]);
        final String title = reader.readString($responseFields[4]);
        final String subtitle = reader.readString($responseFields[5]);
        final Boolean active = reader.readBoolean($responseFields[6]);
        return new DeliveryType(__typename, pocDeliveryTypeId, deliveryTypeId, price, title, subtitle, active);
      }
    }
  }

  public static class PaymentMethod {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forString("pocPaymentMethodId", "pocPaymentMethodId", null, true),
      ResponseField.forString("paymentMethodId", "paymentMethodId", null, true),
      ResponseField.forBoolean("active", "active", null, true),
      ResponseField.forString("title", "title", null, true),
      ResponseField.forString("subtitle", "subtitle", null, true)
    };

    final @Nonnull String __typename;

    final @Nullable String pocPaymentMethodId;

    final @Nullable String paymentMethodId;

    final @Nullable Boolean active;

    final @Nullable String title;

    final @Nullable String subtitle;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PaymentMethod(@Nonnull String __typename, @Nullable String pocPaymentMethodId,
        @Nullable String paymentMethodId, @Nullable Boolean active, @Nullable String title,
        @Nullable String subtitle) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      this.pocPaymentMethodId = pocPaymentMethodId;
      this.paymentMethodId = paymentMethodId;
      this.active = active;
      this.title = title;
      this.subtitle = subtitle;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable String pocPaymentMethodId() {
      return this.pocPaymentMethodId;
    }

    public @Nullable String paymentMethodId() {
      return this.paymentMethodId;
    }

    public @Nullable Boolean active() {
      return this.active;
    }

    public @Nullable String title() {
      return this.title;
    }

    public @Nullable String subtitle() {
      return this.subtitle;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], pocPaymentMethodId);
          writer.writeString($responseFields[2], paymentMethodId);
          writer.writeBoolean($responseFields[3], active);
          writer.writeString($responseFields[4], title);
          writer.writeString($responseFields[5], subtitle);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PaymentMethod{"
          + "__typename=" + __typename + ", "
          + "pocPaymentMethodId=" + pocPaymentMethodId + ", "
          + "paymentMethodId=" + paymentMethodId + ", "
          + "active=" + active + ", "
          + "title=" + title + ", "
          + "subtitle=" + subtitle
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(java.lang.Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof PaymentMethod) {
        PaymentMethod that = (PaymentMethod) o;
        return this.__typename.equals(that.__typename)
         && ((this.pocPaymentMethodId == null) ? (that.pocPaymentMethodId == null) : this.pocPaymentMethodId.equals(that.pocPaymentMethodId))
         && ((this.paymentMethodId == null) ? (that.paymentMethodId == null) : this.paymentMethodId.equals(that.paymentMethodId))
         && ((this.active == null) ? (that.active == null) : this.active.equals(that.active))
         && ((this.title == null) ? (that.title == null) : this.title.equals(that.title))
         && ((this.subtitle == null) ? (that.subtitle == null) : this.subtitle.equals(that.subtitle));
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
        h ^= (pocPaymentMethodId == null) ? 0 : pocPaymentMethodId.hashCode();
        h *= 1000003;
        h ^= (paymentMethodId == null) ? 0 : paymentMethodId.hashCode();
        h *= 1000003;
        h ^= (active == null) ? 0 : active.hashCode();
        h *= 1000003;
        h ^= (title == null) ? 0 : title.hashCode();
        h *= 1000003;
        h ^= (subtitle == null) ? 0 : subtitle.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<PaymentMethod> {
      @Override
      public PaymentMethod map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String pocPaymentMethodId = reader.readString($responseFields[1]);
        final String paymentMethodId = reader.readString($responseFields[2]);
        final Boolean active = reader.readBoolean($responseFields[3]);
        final String title = reader.readString($responseFields[4]);
        final String subtitle = reader.readString($responseFields[5]);
        return new PaymentMethod(__typename, pocPaymentMethodId, paymentMethodId, active, title, subtitle);
      }
    }
  }

  public static class PocWorkDay {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forInt("weekDay", "weekDay", null, true),
      ResponseField.forBoolean("active", "active", null, true),
      ResponseField.forObjectList("workingInterval", "workingInterval", null, true)
    };

    final @Nonnull String __typename;

    final @Nullable Integer weekDay;

    final @Nullable Boolean active;

    final @Nullable List<WorkingInterval> workingInterval;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PocWorkDay(@Nonnull String __typename, @Nullable Integer weekDay,
        @Nullable Boolean active, @Nullable List<WorkingInterval> workingInterval) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      this.weekDay = weekDay;
      this.active = active;
      this.workingInterval = workingInterval;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     * The day of the week
     */
    public @Nullable Integer weekDay() {
      return this.weekDay;
    }

    /**
     * Sets if the Time is Active or Not
     */
    public @Nullable Boolean active() {
      return this.active;
    }

    public @Nullable List<WorkingInterval> workingInterval() {
      return this.workingInterval;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeInt($responseFields[1], weekDay);
          writer.writeBoolean($responseFields[2], active);
          writer.writeList($responseFields[3], workingInterval != null ? new ResponseWriter.ListWriter() {
            @Override
            public void write(ResponseWriter.ListItemWriter listItemWriter) {
              for (WorkingInterval $item : workingInterval) {
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
        $toString = "PocWorkDay{"
          + "__typename=" + __typename + ", "
          + "weekDay=" + weekDay + ", "
          + "active=" + active + ", "
          + "workingInterval=" + workingInterval
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(java.lang.Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof PocWorkDay) {
        PocWorkDay that = (PocWorkDay) o;
        return this.__typename.equals(that.__typename)
         && ((this.weekDay == null) ? (that.weekDay == null) : this.weekDay.equals(that.weekDay))
         && ((this.active == null) ? (that.active == null) : this.active.equals(that.active))
         && ((this.workingInterval == null) ? (that.workingInterval == null) : this.workingInterval.equals(that.workingInterval));
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
        h ^= (weekDay == null) ? 0 : weekDay.hashCode();
        h *= 1000003;
        h ^= (active == null) ? 0 : active.hashCode();
        h *= 1000003;
        h ^= (workingInterval == null) ? 0 : workingInterval.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<PocWorkDay> {
      final WorkingInterval.Mapper workingIntervalFieldMapper = new WorkingInterval.Mapper();

      @Override
      public PocWorkDay map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Integer weekDay = reader.readInt($responseFields[1]);
        final Boolean active = reader.readBoolean($responseFields[2]);
        final List<WorkingInterval> workingInterval = reader.readList($responseFields[3], new ResponseReader.ListReader<WorkingInterval>() {
          @Override
          public WorkingInterval read(ResponseReader.ListItemReader reader) {
            return reader.readObject(new ResponseReader.ObjectReader<WorkingInterval>() {
              @Override
              public WorkingInterval read(ResponseReader reader) {
                return workingIntervalFieldMapper.map(reader);
              }
            });
          }
        });
        return new PocWorkDay(__typename, weekDay, active, workingInterval);
      }
    }
  }

  public static class WorkingInterval {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forCustomType("openingTime", "openingTime", null, false, CustomType.TIME),
      ResponseField.forCustomType("closingTime", "closingTime", null, false, CustomType.TIME)
    };

    final @Nonnull String __typename;

    final @Nonnull Object openingTime;

    final @Nonnull Object closingTime;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public WorkingInterval(@Nonnull String __typename, @Nonnull Object openingTime,
        @Nonnull Object closingTime) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      if (openingTime == null) {
        throw new NullPointerException("openingTime can't be null");
      }
      this.openingTime = openingTime;
      if (closingTime == null) {
        throw new NullPointerException("closingTime can't be null");
      }
      this.closingTime = closingTime;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nonnull Object openingTime() {
      return this.openingTime;
    }

    public @Nonnull Object closingTime() {
      return this.closingTime;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], openingTime);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[2], closingTime);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "WorkingInterval{"
          + "__typename=" + __typename + ", "
          + "openingTime=" + openingTime + ", "
          + "closingTime=" + closingTime
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(java.lang.Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof WorkingInterval) {
        WorkingInterval that = (WorkingInterval) o;
        return this.__typename.equals(that.__typename)
         && this.openingTime.equals(that.openingTime)
         && this.closingTime.equals(that.closingTime);
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
        h ^= openingTime.hashCode();
        h *= 1000003;
        h ^= closingTime.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<WorkingInterval> {
      @Override
      public WorkingInterval map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Object openingTime = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final Object closingTime = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[2]);
        return new WorkingInterval(__typename, openingTime, closingTime);
      }
    }
  }

  public static class Address {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forString("address1", "address1", null, true),
      ResponseField.forString("address2", "address2", null, true),
      ResponseField.forString("number", "number", null, true),
      ResponseField.forString("city", "city", null, true),
      ResponseField.forString("province", "province", null, true),
      ResponseField.forString("zip", "zip", null, true),
      ResponseField.forString("coordinates", "coordinates", null, true)
    };

    final @Nonnull String __typename;

    final @Nullable String address1;

    final @Nullable String address2;

    final @Nullable String number;

    final @Nullable String city;

    final @Nullable String province;

    final @Nullable String zip;

    final @Nullable String coordinates;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Address(@Nonnull String __typename, @Nullable String address1, @Nullable String address2,
        @Nullable String number, @Nullable String city, @Nullable String province,
        @Nullable String zip, @Nullable String coordinates) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      this.address1 = address1;
      this.address2 = address2;
      this.number = number;
      this.city = city;
      this.province = province;
      this.zip = zip;
      this.coordinates = coordinates;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable String address1() {
      return this.address1;
    }

    public @Nullable String address2() {
      return this.address2;
    }

    public @Nullable String number() {
      return this.number;
    }

    public @Nullable String city() {
      return this.city;
    }

    public @Nullable String province() {
      return this.province;
    }

    public @Nullable String zip() {
      return this.zip;
    }

    /**
     * POC Coordinates
     */
    public @Nullable String coordinates() {
      return this.coordinates;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], address1);
          writer.writeString($responseFields[2], address2);
          writer.writeString($responseFields[3], number);
          writer.writeString($responseFields[4], city);
          writer.writeString($responseFields[5], province);
          writer.writeString($responseFields[6], zip);
          writer.writeString($responseFields[7], coordinates);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Address{"
          + "__typename=" + __typename + ", "
          + "address1=" + address1 + ", "
          + "address2=" + address2 + ", "
          + "number=" + number + ", "
          + "city=" + city + ", "
          + "province=" + province + ", "
          + "zip=" + zip + ", "
          + "coordinates=" + coordinates
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(java.lang.Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Address) {
        Address that = (Address) o;
        return this.__typename.equals(that.__typename)
         && ((this.address1 == null) ? (that.address1 == null) : this.address1.equals(that.address1))
         && ((this.address2 == null) ? (that.address2 == null) : this.address2.equals(that.address2))
         && ((this.number == null) ? (that.number == null) : this.number.equals(that.number))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.province == null) ? (that.province == null) : this.province.equals(that.province))
         && ((this.zip == null) ? (that.zip == null) : this.zip.equals(that.zip))
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates));
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
        h ^= (address1 == null) ? 0 : address1.hashCode();
        h *= 1000003;
        h ^= (address2 == null) ? 0 : address2.hashCode();
        h *= 1000003;
        h ^= (number == null) ? 0 : number.hashCode();
        h *= 1000003;
        h ^= (city == null) ? 0 : city.hashCode();
        h *= 1000003;
        h ^= (province == null) ? 0 : province.hashCode();
        h *= 1000003;
        h ^= (zip == null) ? 0 : zip.hashCode();
        h *= 1000003;
        h ^= (coordinates == null) ? 0 : coordinates.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Address> {
      @Override
      public Address map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String address1 = reader.readString($responseFields[1]);
        final String address2 = reader.readString($responseFields[2]);
        final String number = reader.readString($responseFields[3]);
        final String city = reader.readString($responseFields[4]);
        final String province = reader.readString($responseFields[5]);
        final String zip = reader.readString($responseFields[6]);
        final String coordinates = reader.readString($responseFields[7]);
        return new Address(__typename, address1, address2, number, city, province, zip, coordinates);
      }
    }
  }

  public static class Phone {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forString("phoneNumber", "phoneNumber", null, true)
    };

    final @Nonnull String __typename;

    final @Nullable String phoneNumber;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Phone(@Nonnull String __typename, @Nullable String phoneNumber) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      this.phoneNumber = phoneNumber;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable String phoneNumber() {
      return this.phoneNumber;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], phoneNumber);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Phone{"
          + "__typename=" + __typename + ", "
          + "phoneNumber=" + phoneNumber
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(java.lang.Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Phone) {
        Phone that = (Phone) o;
        return this.__typename.equals(that.__typename)
         && ((this.phoneNumber == null) ? (that.phoneNumber == null) : this.phoneNumber.equals(that.phoneNumber));
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
        h ^= (phoneNumber == null) ? 0 : phoneNumber.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Phone> {
      @Override
      public Phone map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String phoneNumber = reader.readString($responseFields[1]);
        return new Phone(__typename, phoneNumber);
      }
    }
  }
}
