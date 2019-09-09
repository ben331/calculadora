import java.util.Scanner;
import java.math.BigDecimal;
/**
*Esta clase es una calculadora cientifica alternativa que contiene 18 funciones.
*@author Benjamin Silva Salgado
*@version 1.0
*/

public class Calculator
{
	//Constantes del dominio de  INT selection
		
	public final static int ADDITION=1;
	public final static int SUBTRATION=2;
	public final static int DIVISION=3;
	public final static int MULTIPLICATION=4;
	public final static int MODULE=5;
	public final static int SIN=6;
	public final static int COS=7;
	public final static int TAN=8;
	public final static int LOG=9;
	public final static int LOG_BASE_N=10;
	public final static int SQUARE_ROOT=11;
	public final static int N_ROOT=12;
	public final static int POTENCY=13;
	public final static int BASE10=14;
	public final static int FACTORIAL=15;
	public final static int CONVERSION=16;
	public final static int MEMORY=17;	
	public final static int FLOW=18;
	//Constantes del dominio de INT Selection despues de seleccionar CONVERSION.
	public final static int DEGREES_TO_RADIANS=1;
	public final static int RADIANS_TO_DEGREES=2;
	public final static int BINARY_TO_HEXADECIMAL=3;
	public final static int HEXADECIMAL_TO_BINARY=4;
	public final static int DECIMAL_TO_HEXADECIMAL=5;
	public final static int HEXADECIMAL_TO_DECIMAL=6;
	public final static int DECIMAL_TO_BINARY=7;
	public final static int BINARY_TO_DECIMAL=8;
	//Symbols
	public final static String SUM="+";
	public final static String SUB="-";
	public final static String FAC="*";
	public final static String COC="/";
	public final static String CENTINELA2="#";
	
	//Constantes matematicas
	public final static double PI=Math.PI;
	
	//Atributos
	public static boolean angleInRadians=true;
	public static double[]memory={0,0,0,0,0,0,0,0,0,0};
	
	//Centinela
	public final static int CENTINELA=-1;
	
	public static void main(String[]args)
	{
		Scanner reader = new Scanner(System.in);

		
		//variables
		double num1=0;
		double num2=0;
		int num3=0;
		int decimal=0;
		int selection=0;
		double result=0;
		double approximateRoot=0;
		String operator;
		String hexadecimal="";
		String binary="";
		String message="";
		String inPut="";
		String angle="Radians";
		
		//Entradas

		System.out.println("Welcome to Alternative Calculator. \n \n Select the Math Funtion");
		System.out.println("The result of every operation will save in a memory. \n You can see the memory typing tha symbol 'SM', \n and you can use the memory typen the letter 'M+the reference of de memory' example: M1 M2 M3 M4... \n \n \n");
		System.out.println("1.Addition \n2.Subtration \n3.Division \n4.Multiplication \n5.Module \n6.Sin \n7.Cos \n8.Tan \n9.Logarithm Base10");
		System.out.println("10.Logarithm base n \n11.Square Root \n12.n Root \n13.Potency. \n14.Base10 of a number \n15.Factorial \n16.Conversion \n17.Setup \n18.Operations flow");
		selection= reader.nextInt();
		System.out.println("\n \n \n");
		
		while (selection!=CENTINELA)
		{
			switch (selection)
			{
				case ADDITION:
				System.out.print("Sum \nFirst adding: ");
				inPut=reader.next();
				num1= VerifyInPut(inPut);
				System.out.print("\nSecond adding: ");
				inPut=reader.next();
				num2= VerifyInPut(inPut);
				result= add(num1, num2);
				System.out.print("\n                ="+result);
				SaveInMemory(memory, result);
				break;
				
				
				case SUBTRATION:
				System.out.print("Subtration \nFirst num: ");
				inPut=reader.next();
				num1= VerifyInPut(inPut);
				System.out.print("\nSecond num: ");
				inPut=reader.next();
				num2= VerifyInPut(inPut);
				result=subtrat(num1, num2);
				System.out.println("\n                ="+result);
				SaveInMemory(memory, result);
				break;
				
				
				case DIVISION:
				System.out.print("\nDivision \n dividend: ");
				inPut=reader.next();
				num1= VerifyInPut(inPut);
				System.out.print("\ndivider: ");
				inPut=reader.next();
				num2= VerifyInPut(inPut);
				if (num2==0)
				{
					System.out.println("Math errror, division by 0 is undefined");
				}
				else
				{
					result=divide(num1, num2);
					System.out.println("\n     ="+result);
					SaveInMemory(memory, result);
				}
				break;
				
				
				case MULTIPLICATION:
				System.out.print("\nMultiplication \n First num: ");
				inPut=reader.next();
				num1= VerifyInPut(inPut);
				System.out.print("\nSecond num: ");
				inPut=reader.next();
				num2= VerifyInPut(inPut);
				result=Multiply(num1, num2);
				System.out.println("                ="+result);
				SaveInMemory(memory, result);
				break;
				
				
				case MODULE:
				System.out.print("\nModule \n Dividend: ");
				inPut=reader.next();
				num1= VerifyInPut(inPut);
				System.out.print("\nDivisor: ");
				inPut=reader.next();
				num2= VerifyInPut(inPut);
				result=calculateModule(num1, num2);
				System.out.println("                ="+result);
				SaveInMemory(memory, result);
				break;
				
				
				case SIN:
				System.out.print("\nSin \n sin of: ");
				inPut=reader.next();
				result=Sin(inPut, angleInRadians);
				System.out.println("                ="+result);
				SaveInMemory(memory, result);
				break;
				
				
				case COS:
				System.out.print("\nCos \n cos of: ");
				inPut=reader.next();
				result=Cos(inPut, angleInRadians);
				System.out.println("                ="+result);
				SaveInMemory(memory, result);
				break;
				
				
				case TAN:
				System.out.print("\nTan \n tan: ");
				inPut=reader.next();
				result=Tan(inPut, angleInRadians);
				System.out.println("                ="+result);
				SaveInMemory(memory, result);
				break;
				
				
				case LOG:
				System.out.print("\nLOG base 10 \n LOG of: ");
				inPut=reader.next();
				num1= VerifyInPut(inPut);
				if (num1<=0)
				{
					System.out.print("\nThe logarithm of a negative number or zero is undefined");
				}
				else
				{
					result=Math.log10(num1);
					System.out.println("        = "+result);
					SaveInMemory(memory, result);
				}
				break;
				
				
				case LOG_BASE_N:
				System.out.print("\nLogarithm baseA. \n Base: ");
				inPut=reader.next();
				num1= VerifyInPut(inPut);
				System.out.print("\nargument: ");
				inPut=reader.next();
				num2= VerifyInPut(inPut);
				if((num1<=0 || num1==1)||(num2<=0))
				{
					System.out.println("Math Error. Base have to be higher or equal to zero, and different to 1, and argument have to be higher than zero");
				}
				else
				{
					result=LogAX(num1, num2);
					System.out.println("            Logarithm = "+result);
					SaveInMemory(memory, result);
				}
				break;
				
				
				case SQUARE_ROOT:
				System.out.print("\nSquare root of:  ");
				inPut=reader.next();
				num1= VerifyInPut(inPut);
				if (num1<0)
				{
					System.out.println("The square root of a negative number is undefined");
				}
				else
				{
					result =calculateSquareRoot(num1);	
					System.out.print("\n \n               = ");
					System.out.printf("%.3f",result);
					SaveInMemory(memory, result);
				}
				break;
				
				
				case N_ROOT:
				System.out.print("\nN_Root \n argument: ");
				inPut=reader.next();
				num1= VerifyInPut(inPut);
				System.out.print("\nindex: ");
				num3=reader.nextInt();
				if(num3%2==0 && num1<0)
				{
					System.out.println("The root of pair index of a negative number is undefined");
				}
				else if(num3==0)
				{
					System.out.println("Math Error. Invalided index");
				}
				else
				{
					result=CalculateNRoot(num1, num3);
					System.out.println("        = "+result);
					SaveInMemory(memory, result);
				}
				break;
				
				
				case POTENCY:
				System.out.print("\nPow \n base: ");
				inPut=reader.next();
				num1= VerifyInPut(inPut);
				System.out.print("\nPow \n exponent: ");
				num3=reader.nextInt();
				if(num1==0 && num3<=0)
				{
					System.out.println("Math Error");
				}
				else
				{
					result=pow(num1, num3);
					System.out.println("                ="+result);
					SaveInMemory(memory, result);
				}
				break;
				
				
				case BASE10:
				System.out.print("\nScientificNotation. \nBase10 of: ");
				inPut=reader.next();
				num1= VerifyInPut(inPut);
				message=ScientificNotation(num1);
				System.out.println("            =  "+message);
				break;
				
				
				case FACTORIAL:
				System.out.print("\nFactorial \n factorial of: ");
				inPut=reader.next();
				num3=VerifyInPutInt(inPut);
				if(num3<0)
				{
					System.out.println("Math Error: Factorial is only allowed for natural numbers");
				}
				else
				{
					result=CalculateFactorial(num3);
					System.out.println("                ="+result);
					SaveInMemory(memory, result);
				}
				
				break;
				
				
				case CONVERSION:
				System.out.println("(Press -1 to exit ) \n1.Conversion degrees to radians \n2.Conversion radians to degrees \n3.Conversion binary to hexadecimal");
				System.out.println("4.Conversion de hexadecimal to binary \n5.Conversion decimal to hexadecimal \n6.Conversion hexadecimal to decimal");
				System.out.println("7.Conversion decimal to binary \n8.Conversion de binary to hexadecimal");
				selection=reader.nextInt();
				System.out.println("\n \n \n");
				
				while (selection!=CENTINELA)
				{
					switch (selection)
					{
						case DEGREES_TO_RADIANS:
						System.out.print("\nput the angle in degrees");
						num1=reader.nextDouble();
						message=DegToRad(num1);
						System.out.println(num1+" degrees equals to "+message+" radians");
						break;
						
						case RADIANS_TO_DEGREES:
						System.out.print("\nput the angle in radians. Ex(22, 3PI, PI, 0,5PI...)");
						message=reader.next();
						result=RadToDeg(message);
						System.out.println(message+" radians equals to "+result+" degrees");
						break;
						
						case BINARY_TO_HEXADECIMAL:
						System.out.print("\nput the binary number");
						binary=reader.next();
						hexadecimal=DecToHex(BinToDec(binary));
						System.out.println("binary "+binary+" equals to "+hexadecimal+" Hexadecimal");
						break;
						
						case HEXADECIMAL_TO_BINARY:
						System.out.print("\nput the hexadecimal number");
						hexadecimal=reader.next();
						binary=DecToBin(HexToDec(hexadecimal));
						System.out.println("Hexadecimal "+hexadecimal+" equals to "+binary+" Binary");
						break;
						
						case DECIMAL_TO_HEXADECIMAL:
						System.out.print("\nput the decimal number");
						decimal=reader.nextInt();
						if (decimal<0)
						{
							System.out.println("Error: negative numbers cannot be converted to hexadecimal numbers");
						}
						else
						{
							hexadecimal=DecToHex(decimal);
							System.out.println("decimal "+decimal+" equals to "+hexadecimal+" Hexadecimal");
						}
						break;
						
						case HEXADECIMAL_TO_DECIMAL:
						System.out.print("\nput the hexadecimal number");
						hexadecimal=reader.next();
						decimal=HexToDec(hexadecimal);
						System.out.println("Hexadecimal "+hexadecimal+" equals to "+decimal+" Decimal");
						break;
						
						case DECIMAL_TO_BINARY:
						System.out.print("\nput the decimal number");
						decimal=reader.nextInt();
						if (decimal<0)
						{
							System.out.println("Error: negative numbers cannot be converted to binary numbers");
						}
						else
						{
							binary=DecToBin(decimal);
							System.out.println("decimal "+decimal+" equals to "+binary+" binary");
						}
						break;
						
						case BINARY_TO_DECIMAL:
						System.out.print("\nput the binary number");
						binary=reader.next();
						decimal=BinToDec(binary);
						System.out.println("binary "+binary+" equals to "+decimal+" decimal");
						break;
						
						default:
						System.out.print("\nInvalid Option");
						break;
					}
					System.out.println("(Press -1 to exit ) \n1.Conversion degrees to radians \n2.Conversion radians to degrees \n3.Conversion binary to hexadecimal");
					System.out.println("4.Conversion de hexadecimal to binary \n5.Conversion decimal to hexadecimal \n6.Conversion hexadecimal to decimal");
					System.out.println("7.Conversion decimal to binary \n8.Conversion de binary to hexadecimal");
					selection=reader.nextInt();
					System.out.println("\n \n \n");
				}
				break;
				case MEMORY:
				System.out.println("Settings: \n1.See Memory \n2.Clean Memory \n3.Angle Notation");
				selection=reader.nextInt();
				switch (selection)
				{
					case 1:
					System.out.println("Current Memory: \n"+ShowMemory(memory));
					break;
					
					case 2:
					CleanMemory(memory);
					System.out.println("Memory has been cleaned");
					
					case 3:
					System.out.println("Current notation is "+angle+", Select the angle Notation \n1.Radians \n2.Degrees  \n3.ToExit");
					selection=reader.nextInt();
				
					switch (selection)
					{
						case 1:
						angleInRadians=true;
						angle="Radians";
						break;
						case 2:
						angleInRadians=false;
						angle="Degrees";
						break;
					}
		
				}
				break;
				
				case FLOW:
				System.out.println("type the first digit, then type anynumber of times: a operator (+ - * /),and then type the second number consecutively. If you want to finish the flow mode , when you have to type the operation type #");
				num1=reader.nextDouble();
				operator=reader.next();
				while(!(operator.equals("#")))
				{
					num2=reader.nextDouble();
					result=doOperation(num1, num2, operator);
					num1=doOperation(num1, num2, operator);
					System.out.println("||\n"+result);
					operator=reader.next();
				}
				break;
				
				
				default:
				System.out.println("\nInvalid Option");
				break;
			}
			
			
			
			System.out.println(" \n \n (Press -1 to exit).\nSelect the Math Funtion or press # to change to simple Mode.");
			System.out.println("The result of every operation will save in a memory. \n You can see the memory typing tha symbol 'SM', \n and you can use the memory typen the letter 'M+the reference of de memory' example: M1 M2 M3 M4... \n \n \n");
			System.out.println("1.Addition \n2.Subtration \n3.Division \n4.Multiplication \n5.Module \n6.Sin \n7.Cos \n8.Tan \n9.Logarithm Base10");
			System.out.println("10.Logarithm base n \n11.Square Root \n12.n Root \n13.Potency. \n14.Base10 of a number \n15.Factorial \n16.Conversion \n17.Setup \n18.Operations flow");
			selection= reader.nextInt();
			System.out.println("\n \n \n");
		}
	}

























	
	//MÉTODOS:
	
	//Operaciones básicas.
	

	//SUMA
	/**
	*<b>DESCRIPCIÓN:</b> Este método calcula la suma de dos números reales <br>
	
	*<b>PRE:</b> Ambos números son reales<br>
	*<b>POST:</b> La suma es un número real<br>
	
	*@param num1 Es el primer sumando real. num1!=null
	*@param num2 Es el segundo sumando real. num2!=null
	
	*@return sum Es la suma de los parametros. sum!=null
	*/
	public static double add(double num1, double num2)
	{
		double sum;
		sum=(num1+num2);
		return sum;
	}
	
	
	
	//RESTA
	/**
	*<b>DESCRIPCIÓN:</b> Este método calcula la resta de dos números reales <br>
	
	*<b>PRE:</b> Ambos números son reales<br>
	*<b>POST:</b> La resta es un número real<br>
	
	*@param num1 Es el numero real minuendo. num1!=null
	*@param num2 Es el numero real sustraendo. num2!=null
	
	*@return subtration Es la diferencia de los parametros. sum!=null
	*/
	public static double subtrat(double num1, double num2)
	{
		double subtration;
		subtration=(num1-num2);
		return subtration;
	}
	
	
	
	//DIVISIÓN.
	/**
	*<b>DESCRIPCIÓN:</b> Este método calcula el cociente de dos números reales <br>
	
	*<b>PRE:</b> Ambos números son reales, y el divisor es diferente de cero<br>
	*<b>POST:</b> La división es un número real<br>
	
	*@param dividend Es el dividendo. dividend!=null 
	*@param diviser Es el divisor. diviser!=null, diviser!=0
	
	*@return quotient Es el cociente de la división. quotient!=null
	*/
	public static double divide(double dividend, double diviser)
	{
		double quotient;
		quotient=(dividend/diviser);
		return quotient;
	}
	
	
	
	//MULTIPLICACIÓN
	/**
	*<b>DESCRIPCIÓN:</b> Este método calcula sl producto de dos números reales <br>
	
	*<b>PRE:</b> Ambos números son reales <br>
	*<b>POST:</b> El producto es un número real <br>
	
	*@param fact1 Es el primer factor. fact!=null
	*@param fact2 Es el segundo factor. fact!=null
	
	*@return product Es el producto de los factores. product!=null
	*/
	public static double Multiply(double fact1, double fact2)
	{
		double product;
		product=(fact1*fact2);
		return product;
	}
	
	
	
	//MODULO
	/**
	*<b>DESCRIPCIÓN:</b> Este método calcula el residuo de una división <br>
	
	*<b>PRE:</b> Ambos parametros son números reales <br>
	*<b>POST:</b> El residuo es un número entero no negativo<br>
	
	*@param dividend Es el dividendo. dividend!=null
	*@param diviser Es el divisor. diviser!=null, diviser!=0
	
	*@return module Es el residuo de la división. module!=null
	*/
	public static double calculateModule(double dividend, double diviser)
	{
		double module;
		module= dividend%diviser;
		return module;
	}
	
	
	
	
	
	
	
	
	
	
	
	//Operaciones Complejas
	
	//SENO
	/**
	*<b>DESCRIPCIÓN:</b> Este método calcula el seno de un número real, ya sea en radianes o en grados<br>
	
	*<b>PRE:</b> El argumento del seno es un número real dado en una cadena que <br>
	*solo puede contener el simbolo "PI" y/o los números reales, pero no puede tener simbolos o números despues del simbolo "PI"<br>
	*La notación del angulo está definida en el atributo booleano angleInRadians, siendo su valor true equivalente a radianes y false equivalente a grados<br>
	*El atributo angleInRadians está instanciado, declarado e inicializado en la clase, el cual puede ser modificado posteriormente.
	*La clase Math.BigDecimal del API de java está importada en la clase<br>
	
	*<b>POST:</b> El seno del número es un número real menor o igual a 1 y mayor o igual a -1<br>
	
	*@param angle Es el ángulo o el argumento del seno. angle!=null, angle!=""
	*@param angleInRadians Es la notacion del ángulo, siendo true=radianes y false=grados. angleInRadians!=null, angleInRadians=(true or false)
	
	*@return sin Es el seno del número ingresado. sin!=null
	*/
	public static double Sin(String angle, boolean angleInRadians)
	{
		double sin=0;
		double argument=0;
		if (angleInRadians==false)
		{
			argument=(Double.parseDouble(angle))/180*Math.PI;
		}
		else
		{
			argument=RadToValueRad(angle);
		}
		sin=Math.sin(argument);
		return sin;
	}
	
	
	
	//COSENO
	/**
	*<b>DESCRIPCIÓN:</b> Este método calcula el coseno de un número real, ya sea en radianes o en grados<br>
	
	*<b>PRE:</b> El argumento del coseno es un número real dado en una cadena que <br>
	*solo puede contener el simbolo "PI" y/o los números reales, pero no puede tener simbolos o números despues del simbolo "PI"<br>
	
	*La notación del angulo está definida en el atributo booleano angleInRadians, siendo su valor true equivalente a radianes y false equivalente a grados<br>
	*El atributo angleInRadians está instanciado, declarado e inicializado en la clase, el cual puede ser modificado posteriormente.<br>
	*La clase Math.BigDecimal del API de java está importada en la clase<br>
	
	*<b>POST:</b> El seno del número es un número real menor o igual a 1 y mayor o igual a -1<br>
	
	*@param angle Es el ángulo o el argumento del seno. angle!=null, angle!=""
	*@param angleInRadians Es la notacion del ángulo, siendo true==radianes y false==grados. angleInRadians!=null, angleInRadians=(true or false)
	
	*@return cos Es el coseno del número ingresado. cos!=null
	*/
	public static double Cos(String angle, boolean angleInRadians)
	
	{
		double cos=0;
		double argument=0;
		if (angleInRadians==false)
		{
			argument=(Double.parseDouble(angle))/180*Math.PI;
		}
		else
		{
			argument=RadToValueRad(angle);
		}
		cos=Math.cos(argument);
		return cos;
	}
	
	
	
	//TANGENTE
	/**
	*<b>DESCRIPCIÓN:</b> Este método calcula el coseno de un número real, ya sea en radianes o en grados<br>
	
	*<b>PRE:</b> El argumento del coseno es un número real dado en una cadena que <br>
	*solo puede contener el simbolo "PI" y/o los números reales, pero no puede tener simbolos o números despues del simbolo "PI"<br>
	
	*La notación del angulo está definida en el atributo booleano angleInRadians, siendo su valor true equivalente a radianes y false equivalente a grados<br>
	*El atributo angleInRadians está instanciado, declarado e inicializado en la clase, el cual puede ser modificado posteriormente.<br>
	*La clase Math.BigDecimal del API de java está importada en la clase<br>
	
	*<b>POST:</b> La tangente del número ingresado es un número real menor o igual a 1 y mayor o igual a -1<br>
	
	*@param angle Es el ángulo o el argumento de la tangente dado en una cadena. angle!=null, angle!=""
	*@param angleInRadians Es la notacion del ángulo dado en un dato booleano,  siendo true==radianes y false==grados. angleInRadians!=null, angleInRadians=(true or false)
	
	*@return sin Es la tangente del número ingresado. tan!=null
	*/
	public static double Tan(String angle, boolean angleInRadians)
	
	{
		double tan=0;
		double argument=0;
		if (angleInRadians==false)
		{
			argument=(Double.parseDouble(angle))/180*Math.PI;
		}
		else
		{
			argument=RadToValueRad(angle);
		}
		if ((argument-(0.5*Math.PI))%1==0)
		{
			System.out.println(" Tan is undefined for this number");
			tan=0;
		}
		tan=Math.tan(argument);
		return tan;
	}
	
	
	
	//LOGARITMO BASE N
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite calcular el logaritmo de un número <br>
	
	*<b>PRE:</b> La base es mayor o igual a cero, y diferente de 1. El argumento es mayor o igual a cero<br>
	* La clase Math.BigDecimal esta importada en la clase.<br>
	
	*<b>POST:</b> El logaritmo del número ingresado es un número real<br>
	
	*@param base Es la base del logaritmo. base mayor o igual a 0, base!=1, base!=null
	*@param argument Es el argumento del logaritmo. argument mayor o igual a 0, argument!=null
	
	*@return root Es el logaritmo de los parametros ingresados. root!=null
	*/	
	public static double LogAX(double base, double argument)
	{
		double logarithm;
		logarithm=(Math.log(argument))/(Math.log(base));
		return logarithm;
	}
	
	
	
	//RAIZ CUADRADA
	/**
	*<b>DESCRIPCIÓN:</b> Este método calcula la raíz cuadrada de un número real no negativo<br>
	
	*<b>PRE:</b> Ambos parametros son números reales no negativos<br>
	*<b>POST:</b> La raiz es un número real no negativo<br>
	
	*@param argument Es el argumento o radicando de la raíz. argument!=null, argument mayor o igual a 0
	
	*@return sqrt Es la raíz cuadrada del número ingresado. sqrt!=null, sqrt mayor o igual a 0
	*/
	public static double calculateSquareRoot(double argument)
	{
		double sqrt=argument;
		if(argument>0)
		{
			double error=1;
			while (error>0.0001)
			{
				sqrt=(sqrt)/2 + (argument/(2*sqrt));
				error=((sqrt*sqrt-argument)>=0 ? (sqrt*sqrt-argument):(argument-sqrt*sqrt));
			}
		}
		else
		{
			sqrt=0;
		}
		return sqrt;
	}	
	
	
	
	//RAIZ ENÉSIMA
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite calcular la raiz n de un número real<br>
	
	*<b>PRE:</b> El argumento es un número real, pero si el indice es par entonces el argumento es un entero no negativo, el indice es un número entero<br>
	* La clase Math.BigDecimal esta importada en la clase.<br>
	
	*<b>POST:</b> La raíz es un número real. Si el indice es par, la raiz es un número entero no negativo<br>
	
	*@param argument Es el argumento de la raiz. argument!=null
	*@param index Es el indice de la raiz. Int index!=null
	
	*@return root Es la raiz de los parametros ingresados. root!=null
	*/
	public static double CalculateNRoot(double argument, double index)
	{
		double root;
		boolean esNegativo=false;
		if (index<0)
		{
			index*=-1;
			esNegativo=true;
		}
		root=Math.pow(argument, (1/index));
		if(esNegativo==true)
		{
			root=1/root;
		}
		return root;
	}
	
	
	
	
	//POTENCIACIÓN
	/**
	*<b>DESCRIPCIÓN:</b> Este método calcula la potencia n de un número<br>
	
	*<b>PRE:</b> La base y el exponente no pueden ser cero a la vez. La base es un número real. El exponente es un número entero<br>
	*<b>POST:</b> La potencia es un número real<br>
	
	*@param base Es la base de la potenciación. base!=null
	*@param exponent Es el exponente de la potenciación. exponent!=null, exponent==Integer
	
	*@return power Es la potencia de la base y exponente dado power!=null
	*/
	public static double pow(double base, int exponent)
	{
		double power=base;
		boolean exponentNegativo=false;
		if (base!=0 && exponent==0)
		{
			power=1;
		}
		else
		{
			if (exponent<0)
			{
				exponent*=-1;
				exponentNegativo=true;
			}
			for(int i=1;i<exponent;i++)
			{
				power*=base;

			}
		}
		if (exponentNegativo==true)
		{
			power=1/power;
		}
		return power;
	}
	
	
	
	
	//NÚMERO BASE 10
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite obtener la notacion científica de un número real<br>
	
	*<b>PRE:</b> El número ingresado es un número real<br>
	
	*<b>POST:</b> La notacion cientifica del número ingresado es una cadena de la forma aEb "a por 10 a la b"<br>
	
	*@param num1 Es el número real ingresado. num1!=null
	
	*@return sNotation es la notacion cientifica del numero ingresado en una cadena, sNotation!=null sNotation!=""
	*/
	public static String ScientificNotation(double num1)
	{
		String sNotation="";
		int digits=0;
		double number=num1;
		if(number>=1 || number<=-1)
		{
			if(num1<0)
			{
				number*=-1;
			}
			number=(Math.round(number*100));
			sNotation=""+num1;
			digits=sNotation.length()-2;
			number/=100;
			for(int i=1;i<=digits-1;i++)
			{
				number/=10;
			}
			number=(Math.round(number*100));
			number/=100;
			if(num1<0)
			{
				number*=-1;
			}
			sNotation=number+"E"+(digits-1);			
		}
		else if((num1>0 && num1<1) || (num1<0 && num1>=-1) )
		{
			if(num1<0)
			{
				number*=-1;
			}
			for(int i=1;number<1;i++)
			{
				number*=10;
				digits=-i;
			}
			if(num1<0)
			{
				number*=-1;
			}
			number=(Math.round(number*100));
			number/=100;
			sNotation=number+"E"+(digits);	
		}
		else
		{
			sNotation=("0E0");
		}
		return sNotation;
	}
	
	
	
	
	
	//FACTORIAL
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite obtener el factorial de un número entero no negativo<br>
	
	*<b>PRE:</b> El número ingresado es un número entero no negativo<br>
	
	*<b>POST:</b> El factorial del número es un número entero no negativo<br>
	
	*@param nonNegativeInteger Es el número ingresado nonNegativeInteger!=null, nonNegativeInteger! mayor o igual a 0
	
	*@return factorial Es el factorial del número ingresado factorial!=null, factorial mayor o igual a 0
	*/
	public static int CalculateFactorial(int nonNegativeInteger)
	{
		int factorial=nonNegativeInteger;
		if (nonNegativeInteger==0)
		{
			factorial=1;
		}
		else
		{
			for(int i=nonNegativeInteger; i>1;i--)
			{
				factorial= factorial*(i-1);
			}
		}
		return factorial;
	}


	
	
	

	
	
	
	

	
	
	

	
	
	
	//Conversions
	
	//VALOR REAL DE UNA EXPRESION EN RADIANES
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite calcular el valor númerico de una cadena que expresa un número en radianes <br>
	
	*<b>PRE:</b> La cadena solo cOntiene números y/o el simbolo "PI". La cadena no contiene más caracteres despues del simbolo"PI". La cadena expresa un número o ángulo en radianes<br>
	
	*<b>POST:</b> La coversion es un número real equivalente al ángulo en radianes<br>
	
	*@param rad Es una cadena que expresa un número en radianes. rad!=null rad!=""
	
	*@return conversion Es un número en radianes. conversion!=null
	*/	
	public static double RadToValueRad(String rad)
	{
		double conversion=0;
		boolean hasFactorPI=false;
		if((""+rad.charAt(0)).equals("P"))
		{
			conversion=Math.PI;
		}
		else
		{
			for(int i=1;i<=rad.length()-1;i++)
			{
				if((""+rad.charAt(i)).equals("P"))
				{
					conversion=(Double.parseDouble(rad.substring(0,(i))))*Math.PI;
					hasFactorPI=true;
				}
			}
			if(hasFactorPI==false)
			{
				conversion=Double.parseDouble(rad);
			}
		}
		return conversion;
	}
	
	
	
	//CONVERSIÓN DE RADIANES A GRADOS
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite convertir una expresión en radianes a un número en grados <br>
	
	*<b>PRE:</b> La cadena solo contiene números y/o el simbolo "PI". La cadena no contiene más caracteres despues del simbolo"PI". La cadena expresa un número o ángulo en radianes<br>
	
	*<b>POST:</b> La coversion es un número real equivalente al ángulo en grados<br>
	
	*@param rad Es una cadena que expresa un número en radianes. rad!=null rad!=""
	
	*@return conversion Es un número en grados. conversion!=null
	*/
	public static double RadToDeg(String rad)
	{
		double conversion=0;
		boolean hasFactorPI=false;
		if((""+rad.charAt(0)).equals("P"))
		{
			conversion=180;
		}
		else if((""+rad.charAt(1)).equals("P"))
		{
			conversion=Double.parseDouble(""+rad.charAt(0));
			conversion*=180;
		}
		else
		{
			for(int i=2;i<=rad.length()-2;i++)
			{
				if((""+rad.charAt(i)).equals("P"))
				{
					conversion=(Double.parseDouble(rad.substring(0,(i))))*180;
					hasFactorPI=true;
				}
			}
			if(hasFactorPI==false)
			{
				conversion=Double.parseDouble(rad);
				conversion*=180/PI;
			}
		}
		return conversion;
	}
	
	
	
	//CONVERSIÓN DE GRADOS A RADIANES
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite convertir una un número en grados a una expresión en radianes<br>
	
	*<b>PRE:</b> El dato ingresado es un número real equivalente al ángulo en grados<br>
	
	*<b>POST:</b> La cadena solo contiene números y/o el simbolo "PI". La cadena no contiene más caracteres despues del simbolo"PI". La cadena expresa un número o ángulo en radianes<br>
	
	*@param deg Es un número en grados. deg!=null
	
	*@return rad Es una cadena que expresa un número en radianes. rad!=null rad!=""
	*/
	public static String DegToRad(double deg)
	{
		String rad;
		rad=(deg/180)+("PI");
		return rad;
	}
	


	//CONVERSIÓN DE BINARIO A DECIMAL
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite convertir una una (cadena)expresion de número binario a un número decimal<br>
	
	*<b>PRE:</b> La cadena ingresada es un número binario, es decir, solo contiene unos y ceros<br>
	
	*<b>POST:</b> La conversión es un número natural en entero en notacioón decimal<br>
	
	*@param binary Es un cadena llena de unos y ceros. binary!=null, binary!=""
	
	*@return decimal es un número natural. decimal!=null
	*/
	public static int BinToDec(String binary)
	{
		int decimal=0;
		for(int i=0; i<=binary.length()-1;i++)
		{
			decimal=decimal*2+Integer.parseInt(""+binary.charAt(i));
		}
		return decimal;
	}
	
	
	
	//CONVERSIÓN DE DECIMAL A BINARIO
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite convertir un número decimal en la expresión de un número binario<br>
	
	*<b>PRE:</b> El dato ingresado es un número entero en notacion decimal<br>
	
	*<b>POST:</b> La cadena es la expresión de un número binario<br>
	
	*@param decimal Es un entero en notación decimal. decimal!=null
	
	*@return binary Es una cadena que representa un número binario. binary!=null binary!=""
	*/
	public static String DecToBin(int decimal)
	{
		String binary="";
		int cociente=0;
		int residuo=0;
		if (decimal<2)
		{
			binary=""+decimal;
		}
		else
		{
			while (decimal>=2)
			{
				cociente=decimal/2;
				residuo=decimal%2;
				binary=residuo+binary;
				decimal=cociente;
			}
			binary=cociente+binary;
		}
		return binary;
	}
	
	
	
	
	//CONVERSIÓN DE NOTACIÓN DECIMAL A NOTACIÓN HEXADECIMAL
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite convertir un número decimal en su correspondiente caracter en notacion hexadecimal<br>
	
	*<b>PRE:</b> El dato ingresado es un número entero en notacion decimal, entre 0 y 15<br>
	
	*<b>POST:</b> La cadena contiene un caracter que representa un número hexadecimal<br>
	
	*@param decNotation Es un entero en notación decimal. decNotation!=null decNotation mayor o igual a 0, decNotation menor o igual a15
	
	*@return hex Es una cadena que contiene un solo caracter que representa un número hexadecimal hex!=null hex!=""
	*/
	public static String DecNotationToHexNotation(int decNotation)
	{
		String hex="";
		if (decNotation<=0)
		{
			hex="negativo?";
		}
		else if (decNotation>=0 && (decNotation<=9))
		{
			hex=""+decNotation;
		}
		else if (decNotation==10)
		{
			hex="A";
		}
		else if (decNotation==11)
		{
			hex="B";
		}
		else if (decNotation==12)
		{
			hex="C";
		}
		else if (decNotation==13)
		{
			hex="D";
		}
		else if (decNotation==14)
		{
			hex="E";
		}
		else if (decNotation==15)
		{
			hex="F";
		}
		else
		{
			hex="G";
		}
		return hex;
	}
	
	
	
	//CONVERSIÓN DE DECIMAL A HEXADECIMAL
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite convertir un número decimal en la expresión de un número hexadecimal<br>
	
	*<b>PRE:</b> El dato ingresado es un número entero en notacion decimal<br>
	
	*<b>POST:</b> La cadena es la expresión de un número hexadecimal<br>
	
	*@param decimal Es un entero en notación decimal. decimal!=null
	
	*@return hexadecimal Es una cadena que representa un número hexadecimal. hexadecimal!=null hexadecimal!=""
	*/
	public static String DecToHex(int decimal)
	{
		String hexadecimal="";
		int cociente=0;
		int residuo;
		int decNotation=0;
		String hexNotation="";
		
		if (decimal<16)
		{
			hexadecimal=""+DecNotationToHexNotation(decimal);
		}
		else
		{
			while (decimal>=16)
			{
				cociente=decimal/16;
				residuo=decimal%16;
				decNotation=residuo;
				hexNotation=DecNotationToHexNotation(decNotation);
				hexadecimal=hexNotation+hexadecimal;
				decimal=cociente;
			}
			decNotation=cociente;
			hexNotation=DecNotationToHexNotation(decNotation);
			hexadecimal=hexNotation+hexadecimal;
		}
		return hexadecimal;
	}
	
	
	
	//CONVERSIÓN DE HEXADECIMAL A DECIMAL
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite convertir unA (cadena)expresion de un número hexadecimal a un número decimal<br>
	
	*<b>PRE:</b> La cadena ingresada expresa un número hexadecimal.<br>
	
	*<b>POST:</b> La conversión es un número entero en notación decimal<br>
	
	*@param hexadecimal Es una cadena que representa un número hexadecimal hexadecimal!=null, hexadecimal!=""
	
	*@return decimal es un número natural. decimal!=null
	*/
	public static int HexToDec(String hexadecimal)
	{
		int decimal=0;
		int cociente;
		int residuo;
		String hexNotation="";
		hexNotation=""+hexadecimal.charAt(0);
		cociente=HexNotationToDecNotation(hexNotation);
		for(int i=1;i<=hexadecimal.length()-1;i++)
		{
			hexNotation=""+hexadecimal.charAt(i);
			residuo=HexNotationToDecNotation(hexNotation);
			decimal=cociente*16+residuo;
			cociente=decimal;
		}
		return decimal;
	}
	
	
	
	//CONVERSIÓN DE NOTACION HEXADECIMAL A NOTACION DECIMAL
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite convertir una un caracter hexadecimal a un número decimal<br>
	
	*<b>PRE:</b> El caracter ingresado está en notación hexadecimal, es decir, solo contiene los números del 0 al 9 y las letras de la A a la F<br>
	
	*<b>POST:</b> La conversión es un número entero en notación decimal<br>
	
	*@param hexNotation Es un cadena con un solo caracter en notacion hexadecimal. hexNotation!=null, hexNotation!=""
	
	*@return decimal es un número natural. decimal!=null
	*/
	public static int HexNotationToDecNotation(String hexNotation)
	{
		int decNotation=-1;
		if (hexNotation.equals("0"))
		{
			decNotation=0;
		}
		else if (hexNotation.equals("1"))
		{
			decNotation=1;
		}
		else if (hexNotation.equals("2"))
		{
			decNotation=2;
		}
		else if (hexNotation.equals("3"))
		{
			decNotation=0;
		}
		else if (hexNotation.equals("4"))
		{
			decNotation=4;
		}
		else if (hexNotation.equals("5"))
		{
			decNotation=5;
		}
		else if (hexNotation.equals("6"))
		{
			decNotation=6;
		}
		else if (hexNotation.equals("7"))
		{
			decNotation=7;
		}
		else if (hexNotation.equals("8"))
		{
			decNotation=8;
		}
		else if (hexNotation.equals("9"))
		{
			decNotation=9;
		}
		else if (hexNotation.equals("A"))
		{
			decNotation=10;
		}
		else if (hexNotation.equals("B"))
		{
			decNotation=11;
		}
		else if (hexNotation.equals("C"))
		{
			decNotation=12;
		}
		else if (hexNotation.equals("D"))
		{
			decNotation=13;
		}
		else if (hexNotation.equals("E"))
		{
			decNotation=14;
		}
		else if (hexNotation.equals("F"))
		{
			decNotation=15;
		}
		else
		{
			System.out.println("Unvalidated Hexadecimal");
		}
		return decNotation;
	}
	
	
	
	//Procesos de la Memoria
	
	
	//GUARDAR
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite guardar un número real en la primera posición de un arreglo de 10 posiciones, y desplazar los valores anteriores una posición a la derecha, eliminando el último valor del arreglo<br>
	
	*<b>PRE:</b> El número ingresado es un número real<br>
	*La memoria es un arreglo de datos double, de tamaño=10, que ya ha sido instanciado, declarado e inicializado con ceros<br>
	*
	
	*<b>POST:</b> El númerp ingresado ha sido guardado en la posición uno del arrglo.<br>
	*los datos anteriores han sido desplazados a la posicion siguiente<br>
	*El dato de la última posición se ha sobreescrito y por lo tanto se ha perdido<br>
	
	*@param num Es un número real en notación decimal!=null
	*@param memory Es un arreglo de números reales. memory.length=10
	*/
	public static void SaveInMemory(double[]memory, double num)
	{
		for(int i=memory.length-1;i>=1;i--)
		{
			memory[i]=memory[i-1];
		}
		memory[0]=num;
	}
	
	
	
	//MOSTRAR MEMORIA
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite obtener una cadena que contiene los números guardados en todas las posiciones de la memoria<br>
	
	*<b>PRE:</b> La memoria es un arreglo de datos double, de tamaño=10, que ya ha sido instanciado, declarado e inicializado con ceros<br>
	
	*<b>POST:</b> Se obtiene una cadena que contiene los números de cada posición de la memoria<br>

	*@param memory Es un arreglo de números reales. memory.length=10
	
	*@return memoryList Es una cadena que contiene los números de cada posición de la memoria. memoryList!=null, memoryList!=""
	*/
	public static String ShowMemory(double[]memory)
	{
		String memoryList="";
		for(int i=0;i<=9;i++)
		{
			memoryList=memoryList+("\nM"+(i+1)+" = "+memory[i]);
		}
		return memoryList;
	}
	
	
	
	//LIMPIAR MEMORIA
	/**
	*<b>DESCRIPCIÓN:</b> Este método le asigna el numero cero cada una de las posiciones de la memoria<br>
	
	*<b>PRE:</b> La memoria es un arreglo de datos double, de tamaño=10, que ya ha sido instanciado, declarado e inicializado con ceros<br>
	
	*<b>POST:</b> El arreglo ahora tiene el número cero en cada posición<br>

	*@param memory Es un arreglo de números reales. memory.length=10
	*/
	public static void CleanMemory(double[]memory)
	{
		for(int i=0;i<=memory.length-1;i++)
		{
			memory[i]=0;
		}
	}

	
	
	
	
	
	
	//INDENTIFICAR OPERACIÓN
	/**
	*<b>DESCRIPCIÓN:</b> Este método lee dos números reales y un simbolo, luego el simbolo es identificado para realizar su correspondiente operación<br>
	
	*<b>PRE:</b> Los númerso ingresados son números reales. El simbolo ingresado representa una operación(+ - * / )<br>
	
	*<b>POST:</b> Los números ingresados se operan, y el primer número se sobreescribe con el resultado.<br>

	*@param num1 Es un número real. num1!=null
	*@param num2 Es un número real. num2!=null
	*@param operator Es una cadena que contiene un simbolo que representa una operación(+ - * /). operator!=null operator!=""
	
	*@return result Es el resultado de la corerspondiente operación entre los números ingresados. result!=null
	*/
	public static double doOperation(double num1, double num2, String operator)
	{
		double result;
		if (operator.equals("+"))
		{
			result=num1+num2;
		}
		else if(operator.equals("-"))
		{
			result=num1-num2;
		}
		else if(operator.equals("*"))
		{
			result=num1*num2;
		}
		else if(operator.equals("/"))
		{
			result=num1/num2;
		}
		else
		{
			System.out.println("Invalided Operator");
			result=num1;
		}
		num1=result;
		return result;
	}
	
	
	
	//VERIFICAR ENTRADA DEVOLVER DOUBLE
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite identificar si la entrada corresponde a un número real, a la funcion mostrar memoria, o  una referencia en la memoria, devolviendo el valor correspondiente<br>
	
	*<b>PRE:</b> La cadena ingresada representa un número real, una referencia en la memoria(M1 M2 M3 M4 M5 M6 M7 M8 M9) o la función mostrar memoria(SM)<br>
	* El método ShowMemory que genera una cadena de los datos de la memoria está en la clase.<br>
	
	
	*<b>POST:</b> El resultado es un numero REAL.<br>

	*@param inPut Es una cadena que contiene un número real, una referencia en la memoria(M1 M2 M3 M4 M5 M6 M7 M8 M9) o la función mostrar memoria(SM). inPut!=null inPut!=""
	
	*@return result Es la referencia en la memoria o el número ingresado, segun sea el caso. result!=null
	*/	
	public static double VerifyInPut(String inPut)
	{
		double result;
		Scanner keyboard = new Scanner(System.in);
		while(inPut.equals("SM"))
		{
			System.out.println(""+ShowMemory(memory));
			inPut=keyboard.next();
		}
		if(inPut.equals("M1"))
		{
			result=memory[0];
		}
		else if(inPut.equals("M2"))
		{
			result=memory[1];
		}
		else if(inPut.equals("M3"))
		{
			result=memory[2];
		}
		else if(inPut.equals("M4"))
		{
			result=memory[3];
		}
		else if(inPut.equals("M5"))
		{
			result=memory[4];
		}
		else if(inPut.equals("M6"))
		{
			result=memory[5];
		}
		else if(inPut.equals("M7"))
		{
			result=memory[6];
		}
		else if(inPut.equals("M8"))
		{
			result=memory[7];
		}
		else if(inPut.equals("M9"))
		{
			result=memory[8];
		}
		else if(inPut.equals("M10"))
		{
			result=memory[9];
		}
		else
		{
			result=Double.parseDouble(inPut);
		}
		return result;
	}
	
	
	
	
	//VERIFICAR ENTRADA DEVOLVER ENTERO
	/**
	*<b>DESCRIPCIÓN:</b> Este método permite identificar si la entrada corresponde a un número real, a la funcion mostrar memoria, o  una referencia en la memoria, devolviendo el valor correspondiente<br>
	
	*<b>PRE:</b> La cadena ingresada representa un número real, una referencia en la memoria(M1 M2 M3 M4 M5 M6 M7 M8 M9) o la función mostrar memoria(SM)<br>
	* El método ShowMemory que genera una cadena de los datos de la memoria está en la clase.<br>
	
	
	*<b>POST:</b> El resultado es un numero ENTERO.<br>

	*@param inPut Es una cadena que contiene un número real, una referencia en la memoria(M1 M2 M3 M4 M5 M6 M7 M8 M9) o la función mostrar memoria(SM). inPut!=null inPut!=""
	
	*@return result Es la referencia en la memoria o el número ingresado, segun sea el caso. result!=null
	*/	
	public static int VerifyInPutInt(String inPut)
	{
		int result;
		Scanner keyboard = new Scanner(System.in);
		while(inPut.equals("SM"))
		{
			System.out.println(""+ShowMemory(memory));
			inPut=keyboard.next();
		}
		if(inPut.equals("M1"))
		{
			result=(int)memory[0];
		}
		else if(inPut.equals("M2"))
		{
			result=(int)memory[1];
		}
		else if(inPut.equals("M3"))
		{
			result=(int)memory[2];
		}
		else if(inPut.equals("M4"))
		{
			result=(int)memory[3];
		}
		else if(inPut.equals("M5"))
		{
			result=(int)memory[4];
		}
		else if(inPut.equals("M6"))
		{
			result=(int)memory[5];
		}
		else if(inPut.equals("M7"))
		{
			result=(int)memory[6];
		}
		else if(inPut.equals("M8"))
		{
			result=(int)memory[7];
		}
		else if(inPut.equals("M9"))
		{
			result=(int)memory[8];
		}
		else if(inPut.equals("M10"))
		{
			result=(int)memory[9];
		}
		else
		{
			result=Integer.parseInt(inPut);
		}
		return result;
	}
}