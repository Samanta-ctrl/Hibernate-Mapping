# Hibernate-Mapping

In order to inform what value of an object has to be stored in what column of the table, will be taking care by the mapping,  actually mapping can be done using 2 ways,

--> XML
--> Annotations.

Let us see understand a little detail about the mapping elements used in the mapping file −

The mapping document is an XML document having <hibernate-mapping> as the root element, which contains all the <class> elements.

The <class> elements are used to define specific mappings from a Java classes to the database tables. The Java class name is specified using the name attribute of the class element and the database table name is specified using the table attribute.

The <meta> element is optional element and can be used to create the class description.

The <id> element maps the unique ID attribute in class to the primary key of the database table. The name attribute of the id element refers to the property in the class and the column attribute refers to the column in the database table. The type attribute holds the hibernate mapping type, this mapping types will convert from Java to SQL data type.

The <generator> element within the id element is used to generate the primary key values automatically. The class attribute of the generator element is set to native to let hibernate pick up either identity, sequence, or hilo algorithm to create primary key depending upon the capabilities of the underlying database.

The <property> element is used to map a Java class property to a column in the database table. The name attribute of the element refers to the property in the class and the column attribute refers to the column in the database table. The type attribute holds the hibernate mapping type, this mapping types will convert from Java to SQL data type.
  
