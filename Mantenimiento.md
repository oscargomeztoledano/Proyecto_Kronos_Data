# Informe de mantenimiento

## Integrantes de la empresa

	* Óscar Gómez Toledano
	* Victor Centellas Castañares
	* Daniel Martin Gómez
	* David Muñoz Pecci

### Introducción

En este informe de mantenimiento exponemos el mantenimiento correctivo que hemos realizado, buscando cumplir el quality  gate que hemos establecido para el proyecto. Este mantenimiento correctivo lo vamos a realizar sobre la version v1.8.0 y todos los arreglos de errores los realizaremos en una nueva rama que llamaremos "hotfix". La nueva versión tras estos arreglos será v1.8.1.

---

### Analisis de calidad

Establecemos un Quality gate que el analasis de calidad tiene que cumplir. Este qualitygate lo hemos llamado "Krono_Data" y lo hemos configurado con las siguientes condiciones:

Imagen qualitygate.

---

#### Estado actual de la calidad 

Imagen de sonar.

Como podemos observar en la imagen, el estado actual del analisis no cumple el qualitygate y es marcado como "Failed". Esto es debido a que no cumplimos los minimos especificados en el Quality gate en las areas de cobertura de los tests (Coverage) y fiabilidad (Reliability). En este informe nos centraremos en aumentar ratio de fiabilidad, ya que el ratio de cobertura lo aumentaremos realizando más tests.

---

### Resolución de bugs

Como podemos observar en la imagen del apartado anterior tenemos 12 bugs y un ratio de fiabilidad E, para pasar el corte del quality gate seleccionado debemos obtener un ratio de fiabilidad B. Para obtener el ratio de fiabilidad buscado debemos conseguir que los bugs de severidad "Major" sean eliminados

#### Bug "Use try-with-resources or close this "Statement" in a "finally" clause".

Este bug lo encontramos en la clase GestorBD.java, tiene una severidad "Blocker" y se produce 3 veces. Se produce debido a que cerramos la declaración "Statement st = mBD.createStatement();", con "st.close();", dentro del mismo try. Sonar nos sugiere solucionarlo utilizando un "try-with-resource". Hemos cambiado los 3 trys por "try(Statement st = mBD.createStatement())".

#### Bug "Strings and Boxed types should be compared using "equals()"".

Este bug lo encontramos en las clases CursoPropioDAO.java y PantallaMatriculacion.java, tiene una severidad "Major" y se produce 4 veces en estas clases. Se produce debido a que comparamos dos string con "==" y debemos hacerlo con equals(). 

#### Bug "NullPointerException" will be thrown when invoking method "recogerCursos()".

Este bug lo encontramos en las clases GestorBD.java y CursoPropioDAO.java, tiene una severidad "Major" y se produce una vez en cada clase. En GestorBD.java se produce debido a que en la llamada "mBD.setautoCommit(true)" de la linea 50, mBD puede ser igual a null, lo hemos solucionado introduciendo un condicional para que si mBD es igual a null no se realize la llamada. En CursoPropioDAO.java sucede algo parecido en la llamada "listaCursos = recogerCursos(cursos, listaCursos)", en esta llamada cursos puede ser igual a null, actuamos de la misma manera que en GestorBD.java para que si cursos es igual a null no se realize la llamada. Estos bugs nos los notifica sonar ya que inicializamos variables a null para poder utilizarlas.