package com.example.c_tesy;

import util.MyApplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tv1;;
	private Button bt1;
	private MyApplication application;
	public static String a[]={"一个C程序的执行是从:\nA)本程序的main函数开始,到main函数结束\nB)本程序文件的第一个函数开始,到本程序文件的最后一个函数结束\nC)本程序的main函数开始,到本程序文件的最后一个函数结束\nD)本程序文件的第一个函数开始,到本程序main函数结束",
	            				 "以下叙述正确的是:\nA)在C程序中,main函数必须位于程序的最前面\nB)C程序的每行中只能写一条语句\nC)C语言本身没有输入输出语句\nD)在对一个C程序进行编译的过程中,可发现注释中的拼写错误",
		"以下叙述不正确的是:\nA)一个C源程序可由一个或多个函数组成\nB)一个C源程序必须包含一个main函数\nC)C程序的基本组成单位是函数\nD)在C程序中,注释说明只能位于一条语句的后面",
		 "C语言规定:在一个源程序中,main函数的位置 :\nA)必须在最开始\nB)必须在系统调用的库函数的后面\nC)可以任意\nD)必须在最后",
		 "在C语言中(以16位PC机为例),5种基本数据类型的存储空间长度的排列顺序为:\nA)char<int<1ong\tint<=float<double\nB)char=int<1ong\tint<=float<double\nC)char<int<1ongint=float=double\nD)char=int=1ong\tint<=float<double",
		 "一个C语言程序是由:\nA)一个主程序和若干子程序组成\nB)函数组成\nC)若干过程组成\nD)若干子程序组成",
		 "若x,i,j和k都是int型变量,则执行下面表达式后x的值为:\nx=(i=4,j=16,k=32)\nA)4\nB)16\nC)32\nD)52",
		 "所假设有变量均为整型,则表达式(a=2,b=5,b++,a+b)的值是:\nA)7\nB)8\nC)6\nD)2",
		 "下列四组选项中,均不是C语言关键字的选项是:\nA)define B)getc C)include D)while",
		 "下面四个选项中,均是C语言关键字的选项是 :\nA)auto\nB)switch\nC)signed\nD)if",
		 "下面四个选项中,均是不合法的用户标识符的选项是:\nA) A\nB)float\nC)b-a\nD)一123",
		 "C语言中的标识符只能由字母、数字和下划线三种字符组成,且第一个字符:\nA)必须为字母\nB)必须为下划线\nC)必须为字母或下划线\nD)可以是字母,数字和下划线中任一种字符",
		 "下面正确的字符常量是:\nA)'a'\nB)'\\''\nC)'W'\nD)''",
		 "下面正确的字符常量是:\nA)'a'\nB)'\\''\nC)'W'\nD)''",
		 "若有代数式3ae/bc,则不正确的C语言表达式是:\nA) a/b/c*e*3\nB)3*a*e/b/c\nC)3*a*e/b*c\nD)a*e/c/b*3",
		 "已知各变量的类型说明如下: \nint\tk,a,b;\nunsigned\tlong\tw=5;\ndouble\tx=1.42;\n则以下不符合C语言语法的表达式是:\nA)x%(一3)\nB)w+=-2\nC)k=(a=2,b=3,a十b)\nD)a十=a一=(b=4)*(a=3)",
		 "已知各变量的类型说明如下:\nint i=8,k,a,b;\nunsigned long w=5;\ndouble x=1.42,y=5.2;\n则以下符合C语言语法的表达式是:\nA) a十=a一=(b= 4)*(a=3)\nB)a=a*3=2\nC) x%(一3)   D)y=f1oat(i)",
		 "以下不正确的叙述是:\nA)在C程序中,逗号运算符的优先级最低\nB)在C程序中,APH和aph是两个不同的变量\nC)若a和b类型相同,在执行了赋值表达式a=b后b中的值将放人a中,而b中的值不变。\nD)当从键盘输入数据时,对于整型变量只能输入整型数值,对于实型变量只能输入实型数值。",
		 "以下正确的叙述是:\nA)在C程序中,每行中只能写一条语句\nB)若a是实型变量,C程序中允许赋值a=10,因此实型变量中允许存放整型数\nC)在C程序中,无论是整数还是实数,都能被准确无误地表示\nD)在C程序中,%是只能用于整数运算的运算符",
		 "以下符合C语言语法的赋值表达式是:\nA)d=9+e+f=d+9\nB) d=9+e,f=d+9\nC)d=9十e,e++,d十9\nD)d=9十e++=d十7",
		 "已知字母A的ASCII码为十进制数65,且c2为字符型,则执行语句c2='A'十'6'一'3';后,c2中的值为:\nA)DB)68\nC)不确定的值\nD)C",
		 "在C语言中,要求运算数必须是整型的运算符是:\nA) /\nB)++\nc)!=\nD)%",
		 "若以下变量均是整型,且num=sum=7;则执行表达式sUM=num++,sUM++,++num后sum的值为:\nA) 7    B 8   C) 9    D) 10",
		 "在C语言中,int、char和short种类型数据在内存中所占用的字节数:\nA)由用户自己定义\nB)均为2个字节\nC)是任意的\nD)由所用机器的机器字长决定",
		 "若有说明语句:char c='\72'则变量c:\nA)包含1个字符\nB)包含2个字符\nC)包含3个字符\nD)说明不合法,c的值不确定",
		 "若有定义:int a=7;float x=2.5,y=4.7;则表达式x+a%3*(int)(x+y)%2/4的值是:\nA)2·500000   B)2.7500OO \nC)3.500000 D)0.000000。",
		 "sizeof(float)是:\nA)一个双精度型表达式 B)一个整型表达式 \nC)一种函数调用 D)一个不合法的表达式",
		 "设变量a是整型,f是实型,i是双精度型,则表达式10+'a'+i*f值的数据类型为:\nA)int\nB)float\nC)double\nD)不确定",
		 "在C语言中, char型数据在内存中的存储形式是:\nA)补码\nB)反码\nC)原码\nD)ASCII码",
		 "设变量n为f1oat类型,m为int类型,则以下能实现将n中的数值保留小数点后两位,第三位进行四舍五人运算的表达式是:A) n=(n*100+0.5)/100.0\nB)m=n*100+0.5 ,n= m/100.0\nC) n=n*100+0.5/100.0\nD)n=(n/100+0.5)*100.0",
		 "表达式18/4*sqrt(4.0)/8值的数据类型为:\nA) int\nB)float\nC)double\nD)不确定",
		 "设C语言中,一个int型数据在内存中占2个字节,则unsigned int型数据的取值范围为:\nA) 0～255   B) 0～32767\nC) 0～65535   D) 0～2147483647",
		 "设有说明: char w; int x; f1oat y; double z;则表达式w* x+z一y值的数据类型为:\nA)float\nB)char\nC)int\nD)double",
		 "若有以下定义,则能使值为3的表达式是:\nint k= 7,x =12;\nA) x%=(k%= 5)\nB)x%=(k一k%5)\nC)x%=k- k%5\nD) (x%=k)一(k%=5)",
		 "设以下变量均为int类型,则值不等于7的表达式是:\nA) (x= y= 6, x+y,x+1)\nB)(x= y= 6,x+y,y+1)\nC) (x= 6,x+1,y= 6,x+y)\nD) (y=6,y+l,x = y,x+1)",
		 "putchar函数可以向终端输出一个:\nA)整型变量表达式值          B)实型变量值\nC)字符串          D)字符或字符型变量值",
		 "printf函数中用到格式符%5s ,其中数字5表示输出的字符串占用5列。如果字符串长度大于5,则输出按方式:\n A)从左起输出该字串,右补空格\nB)按原字符长从左向右全部输出\nC)右对齐输出该字串,左补空格\nD)输出错误信息",
		 "printf函数中用到格式符%5s ,其中数字5表示输出的字符串占用5列。如果字符串长度小于5,则输出按方式:A)从左起输出该字串,右补空格\nB)按原字符长从左向右全部输出\nC)右对齐输出该字串,左补空格\nD)输出错误信息",
		 " 已有定义 int a=-2;和输出语句:printf('%8lx',a);以下正确的叙述是:\nA)整型变量的输出格式符只有%d一种\nB)%x 是格式符的一种,它可以适用于任何一种类型的数据\nC)%x 是格式符的一种,其变量的值按十六进制输出,但%8lx 是错误的\nD)%8lx 不是错误的格式符,其中数字8规定了输出字段的宽度",
		 "d若x ,y均定义为int型,z定义为double型,以下不合法的scanf函数调用语句是:\nA) scanf('%d%lx,%le',&x,&y,&z);\nB) scanf('%2d * %d%lf'&x,&y,&z );\nC) scanf('%x %* d%o',&x,&y);\nD) scanf('%x%o%6.2f',&x,&y,&z)",
		 "a已有如下定义和输入语句 ,若要求a1,a2,c1,c2值分别为10,20,A和B,当从第一列开始输入数据时,正确的数据输入方式是:\nint a1,a2; char c1,c2;\nscanf('%d%c%d%c',&a1,&c1,&a2,&c2);\nA)10A 20B< CR>\nB)10 A 20 B<CR>\nC)10A20<CR>\nD)10A20 B<cR>。",
		 "b已有定义int x; f1oat y;且执行scanf('%3d%f',&x,&y);语句,若从第一列开始输入数据12345 678(回车),则x 的值为:A)12345\nB)123\nC)45\nD) 345",
        "b已有定义int x; f1oat y;且执行scanf('%3d%f',&x,&y);语句,若从第一列开始输入数据12345 678(回车),则y 的值为:\nA)无定值        B)45.0000\nC) 678.000000   D) 123.00000",
        "已有如下定义和输入语句,若要求a1,a2,c1,c2的值分别为10,20,A,B,当从第一列开始输入数据时,正确的数据输入方式是:\nint a1,a2; char c1,c2;\nscanf('%d%d',&a1,&a2);\nscanf('%c%c',&c1,&c2);\nA) 1020AB<CR>\nB)10 20<CR>AB<CR>\nC)10 20 AB<CR>\nD)10 20AB<CR>",
        "d已有程序段和输入数据的形式如下,程序中输入语句的正确形式应当为:\nmain()\n{int a;float f;\nprintf('\nInput number:');\n输入语句\nprintf('\nf=%f,a= %d,f,a);\n}\nInput number: 4.5 2<CR>\nA )scanf('%d,%f',&a,&f);\nB)scanf('%f,%d',&f,&a) \nC)scanf('%d%f',&a,&f);\nD)scanf('%f%d',&f,&a);",
        "b根据定义和数据的输入方式,输入语句的正确形式为:\n已有定义: float fl,f2;\n数据的输入方式:\n4.52  3.5\nA)scanf('%f,%f',&f1,&f2);\nB)scanf('%f%f',&f1,&f2 );\nC)scanf('%3.2f%2.1f',&f1,&f);\nD)scanf('%3.2f%2.1f',&f1,&f2);", 
        "d阅读以下程序,当输入数据的形式为25,13,10<CR>正确的输出结果为:\nmain()\n{int x,y,z \nscanf('%d%d%d',&x,&y,&z );\nprintf('x+y+z=%d ,x+y+z);。\n}\nA)x +y+z=48 B)x +y+z=35\nC)x +z=35  D)不确定值",
		 "d以下说法正确的是:\nA)输入项可以为一实型常量,如scanf('%f',3.5);\nB)只有格式控制,没有输入项,也能进行正确输入,如scanf('a=%d,b=%d');\nC)当输入一个实型数据时,格式控制部分应规定小数点后的位数, 如scanf('%4.2f',&f);\nD)当输入数据时,必须指明变量的地址,如canf('%f',&f);",
	     "有输入语句:\nscanf('a= %d,b= %d,c=%d',&a,&b,&c);\n为使变量a的值为1,b为3,c为2,从键盘输入数据的正确形式应当是:\nA)132(回车) B)1,3,2(回车)\nC)a=1b=3c=2(回车)D)a=1,b=3,c=2(回车)",
        "a以下能正确地定义整型变量a,b和c 并为其赋初值5的语句是:\nA)int a=b= c= 5;\nB) int a,b, c= 5;\nC)a= 5,b=5,c=5;\nD) a= b= c=5;",
        "a已知ch是字符型变量,下面不正确的赋值语句是:\nA)ch='a+b'; B)ch='\0';\nC)ch='7'+'9'; D) ch=5+9;",
        "b若有以下定义,则正确的赋值语句是:\nint a,b;float x;\nA) a=1,b=2, B)b++;\nC) a= b= 5  D) b= int(x);",
        "b设x 、y均为f1oat型变量,则以下不合法的赋值语句是:\nA)++x;B)y=(x%2)/10;\nC) x*=y+8;  D)x=y=0;",
        "逻辑运算符两侧运算对象的数据类型:\nA)只能是0或1\nB)只能是0或非0正数\nC)只能是整型或字符型数据\nD)可以是任何类型的数据",
        "c下关于运算符优先顺序的描述中正确的是:\nA)关系运算符< 算术运算符< 赋值运算符< 逻辑与运算符\nB)逻辑 运算符< 关系运算符< 算术运算符< 赋值运算符\nC)赋值运算符< 逻辑与运算符< 关系运算符< 算术运算符\nD)算术运算符< 关系运算符< 赋值运算符< 逻辑与运算符",
        "b下列运算符中优先级最高的是:\nA)< \nB)十 \nC)&&\nD)!=",
        "c能正确表示'当x 的取值在[1,10]和[200,210]范围内为真,否则为假'的表达式是:\nA) (x>=1) &&(x<=10) &&(x> = 200) &&(x<=210)\nB) (x>=1) || (x<=10) ||(x>=200) ||(x<=210)\nC) (x>=1) &&(x<=10)||(x>= 200) &&(x<=210)\nD) (x > =1)||(x< =10) && (x> = 200)||(x<=210)",
        "c判断char型变量ch是否为大写字母的正确表达式是:\nA)' A' <=ch<='z'\nB)(ch> = 'A')&(ch<=' z' )\nC)(ch>=' A' )&&(ch<='Z')\nD)(' A' < = ch)AND('z'> = ch)",
        "设x,y 和z是int型变量,且x = 3,y= 4,z= 5,则下面表达式中值为0的是:\nA)'y'&&'y'\nB)x < =y\nC) x||y+z&&y-z\nD) !(x<y)&&!z||1)",
        "c已知x =43,ch='A',y=0则表达式(x > = y && ch<'B'&&!Y) 的值是:\nA)0\nB)语法错\nC)1\nD)'假'",
        "c若希望当A的值为奇数时,表达式的值为'真',A的值为偶数 表达式的值为'假'。则以下不能满足要求的表达式是:\nA) A%2= =1\nB)!(A%2 = =0)\nC)!(A%2)\nD) A%2",
        "b设有 int a = 1,b=2,c =3, d =4, m=2, n=2;\n执行(m= a>b)&&(n=c>d)后n的值为:\nA)1\nB )2\nC)3\nD)4",
        "c执行以下语句后a的值为:\nint a,b,c;\na= b= c= 1;\n++a||++b&&++c\nA)错误\nB) 0\nC) 2\nD) 1",
        "执行以下语句后b 的值为:\nint a=5,b=6,w=1,x=2,y=3,z=4;\n(a=w>x)&&(b=y>z);\nA) 6\nB) 0\nC) 1\nD) 4",
        "c以下不正确的if语句形式是:\nA)if(x>y && x!=y);\nB)if(x= =y) x+=y\nC)if(x != y)scanf('%d',&x )else scanf('%d',&y);\nD)if(X<Y) {X++;Y++;}",
        "a下列运算符中优先级最低的是:\nA)?:\nB)&&\njc)+\nD) !=",
		 "c以下程序的运行结果是 :\nmain()\n{int m=5;\nif(m++> 5) printf('%d\n',m);\ne1se\nprintf('%d\n',m- - );\n}\nA)4\nB)5\nC)6\nD)7",
		 "b为了避免在嵌套的条件语句If一else中产生二义性,C语言规定else子句总是与( )配对。\nA)缩排位置相同的if\nB)其之前最近的if\nC) 之后最近的if\nD)同一行上的if",
        "以下不正确的语句为:\nA) if(x>y);\nB) if (x= y) &&(x! = 0) x+= y;\nC) if(x!= y)scanf('%d',&x); else scanf('%d',&y);\nD)if(x< y){x++ ;y十十;}",
        "b若有条件表达式(exp) ? a++:b--,则以下表达式中能完全等价于表达式(exp)的是:\nA) (exp==0)    B) (exp!=0)\nC) (exp== 1)    D) (exp!=1)",
        "d有输入语句: scanf('a= %d,b= %d,c=%d',&a,&b,&c);\n为使变量a的值为1,b为3,c为2,从键盘输入数据的正确形式应当是:\nA)132(回车) B)1,3,2(回车)\nC)a=1b=3c=2(回车)\nD)a=1,b =3,c =2(回车)",
		 "a以下能正确地定义整型变量a,b和c 并为其赋初值5的语句是:\nA)int a=b= c= 5;\nB) int a,b, c= 5;\nC)a= 5,b=5,c=5;\nD) a= b= c=5;",
		 "a已知ch是字符型变量,下面不正确的赋值语句是:\nA)ch='a+b'; B)ch='\0';\nC)ch='7'+'9'; D) ch=5+9;",
	     "若有以下定义,则正确的赋值语句是:\nint a,b;float x;\nA) a=1,b=2,\nB)b++;\nC) a= b= 5\nD) b= int(x);",
		 "b设x 、y均为f1oat型变量,则以下不合法的赋值语句是:\nA)++x;\nB)y=(x%2)/10;\nC) x*=y+8;\nD)x=y=0;",
		 "d逻辑运算符两侧运算对象的数据类型:\nA)只能是0或1\nB)只能是0或非0正数\nC)只能是整型或字符型数据\nD)可以是任何类型的数据",
		 "c下关于运算符优先顺序的描述中正确的是:\nA)关系运算符< 算术运算符< 赋值运算符< 逻辑与运算符\nB)逻辑 运算符< 关系运算符< 算术运算符< 赋值运算符\nC)赋值运算符< 逻辑与运算符< 关系运算符< 算术运算符\nD)算术运算符< 关系运算符< 赋值运算符< 逻辑与运算符",
		 "b下列运算符中优先级最高的是:\nA)<\nB)十\nC)&&\nD)!= ",
		 "能正确表示'当x 的取值在[1,10]和[200,210]范围内为真,否则为假'的表达式是:\nA) (x>=1) &&(x<=10) &&(x> = 200) &&(x<=210)\nB) (x>=1) || (x<=10) ||(x>=200) ||(x<=210)\nC) (x>=1) &&(x<=10)||(x>= 200) &&(x<=210)\nD) (x > =1)||(x< =10) && (x> = 200)||(x<=210)",
		 "c判断char型变量ch是否为大写字母的正确表达式是:\nA)' A' <=ch<='z'\nB)(ch> = 'A')&(ch<=' z' )\nC)(ch>=' A' )&&(ch<='Z')\nD)(' A' < = ch)AND('z'> = ch)",
		 "d设x,y 和z是int型变量,且x = 3,y= 4,z= 5,则下面表达式中值为0的是:\nA)'y'&&'y'\nB)x < =y \nC) x||y+z&&y-z\nD) !(x<y)&&!z||1)",
		 "c已知x =43,ch='A',y=0则表达式(x > = y && ch<'B'&&!Y) 的值是:\nA)0\nB)语法错\nC)1\nD)'假'",
		 "c若希望当A的值为奇数时,表达式的值为'真',A的值为偶数 表达式的值为'假'。则以下不能满足要求的表达式是:\nA) A%2= =1\nB)!(A%2 = =0)\nC)!(A%2)\nD) A%2",
		 "设有 int a = 1,b=2,c =3, d =4, m=2, n=2;\n执行(m= a>b)&&(n=c>d)后n的值为:\nA)1\nB )2\nC)3\nD)4",
		 "c执行以下语句后a的值为:\nint a,b,c;\na= b= c= 1;\n++a||++b&&++c\nA)错误\nB) 0\nC) 2\nD) 1",
		 "a执行以下语句后b 的值为:\nint a=5,b=6,w=1,x=2,y=3,z=4;\n(a=w>x)&&(b=y>z);\nA) 6\nB) 0\nC) 1\nD) 4",
		 "c以下不正确的if语句形式是:\nA)if(x>y && x!=y);\nB)if(x= =y) x+=y\nC)if(x != y)scanf('%d',&x )else scanf('%d',&y);\nD)if(X<Y) {X++;Y++;}",
		 "a下列运算符中优先级最低的是:\nA)?:\nB)&&\nc)+\nD) !=",
		 "以下程序的运行结果是 :\nmain()\n{int m=5;\nif(m++> 5) printf('%d',m);\ne1se\nprintf('%d',m- - );\n}\nA)4\nB)5\nC)6\nD)7",
		 "b为了避免在嵌套的条件语句If一else中产生二义性,C语言规定else子句总是与( )配对。\nA)缩排位置相同的if\nB)其之前最近的if\nC) 之后最近的if\nD)同一行上的if",
		 "b以下不正确的语句为:\nA) if(x>y);\nB) if (x= y) &&(x! = 0) x+= y;\nC) if(x!= y)scanf('%d',&x); else scanf('%d',&y);\nD)if(x< y){x++ ;y十十;}",
		 "b若有条件表达式(exp) ? a++:b--,则以下表达式中能完全等价于表达式(exp)的是:\nA) (exp==0)   B) (exp!=0)\nC) (exp== 1)    D) (exp!=1)",
		 "d以下程序的运行结果是:\nmain()\n{int k= 4,a=3,b=2,c=;\nprintf('\n %d\n',k< a ? k:c<b ?c :a);\n}\nA)4\nB )3\nC)2\nD)1",
		 "执行以下程序段后、变量a,b,c的值分别是:\nint x=10,y=9;\nint a,b,c;\na =(- -x = = y++)?- -x:++y ;\nb = x ++;\nc = y;\nA )a=9,b= 9,c= 9\nB )a=8,b=8,c=10\nC )a=9,b= 10,c=9\nD )a=1,b= 11,c=10",
		 "d若w=1,X = 2,y= 3,z=4,则条件表达式w<x?w:y<z?y:z的值是:\nA)4\nB)3\nC)2\nD)1",
        "c设有程序段\nint k=10;\nwhile (k=0) k= k-1;\n则下面描述中正确的是\nA) while循环执行10次\nB)循环是无限循环\nC)循环体语句一次也不执行\nD)循环体语句执行一次",
        "b有以下程序段:\nint x=0,s=0;\nwhile (! x!= 0) s+=++x;\nprintf('%d',s);\n则\nA)运行程序段后输出0\nB)运行程序段后输出1\nC)程序段中的控制表达式是非法的\nD)程序段执行无限次",
        "a语句while(!E)中的表达式!E等价于:\nA) E==0\nB) E!=1\nC) E!=0\nD) E==1",
        "b下面程序段的运行结果是:\nif\nn=0;\nwhile(n++<=2); printf('%d',n);A) 2\nB) 3\nC) 4\nD)有语法错",
		 "c以下程序段\nx= -1;\ndo\n{x=x*x;}\nwhile(!x);\nA)是死循环 \nB)循环执行二次\nC)循环执行一次\nD)有语法错误",};
	public static  String b[]={"A","C","D","C","B","A","C","B","A","B","C","C","C","C","C","A","A","D","D","B","A","D","A","D","A","A","B","C","D","B","C","C","D","D","C","D","B","C","D","D","D","A","B","B","D","D","B","D","D","D","A","A","B","B","D","C","B","C","C","D","C","C","B","C","A","C","A","C","B","B","B","D","A","A","B","B","D","C","B","C","C","D","C","C","B","C","A","C","A","C","B","B","D","B","D","D","C","B","A","B"};
	public static String ti[]={"程序段int k=10; while(k=0)  k=k-1循环体语句执行__次",
		"设x=(5>1)+2,x的值 为__.",
"已知x=3,y=2,则表达式x*=y+8的值为__",
"设x的值为15,n的值为2,则表达式x%=(n+=3)运算后x的值是__",
"已知 i=5,写出语句 i*=i+1; 执行后整型变量 i 的值是__",
"int x=2;z=-x+++1; 则x的值为__",
"设(k=a=5,b=3,a*b),则表达式的值为__",
"若有以下定义和语句:int a[4]={0,1,2,3},\n*p;\np=&a[2];\n则*--p的值是__.",
"计算机中内存储器的最小存储单位是__。",
"已知:int i=8,j=10,m,n;m=++i;n=j++;问语句执行后m=__,n=__。",
"C语言把文件看作是一个___的序列.",
"int x;  x=-3+4%-5*3,  则x的值为__.",
"C语言中,二维数组在内存中的存放方式为按__优先存放",
"函数调用语句func((e1,e2),(e3,e4,e5))中含有__个实参.",
"按内存排列顺序, 数组char a[2]中的所有元素是a[1]和__.",
"下列语句输出的结果是__,unsigned int b=65535;printf('%d',b);",
"若x和n均是int型变量,且x和n的初值均为5,则计算表达式 x+=n++ 后x的值为 __,n的值为__.",
"int x=2,y=3,z=4; 则表达式!x+y>z的值为__",
"求字符串长度的库函数是__,只写函数名即可.",
"预处理命令行都必须以__号开始.",
"设a=3,b=4,c=5,则表达式!(a+b)+c-1&&b+c/2的值为__",
"执行下列语句后,b 的十进制值是__.",
"若a是int型变量,则计算表达式 a=25/3%3 后a的值为__",
"表达式18 && 53 的值是__",
"设c语言中,int类型数据占2个字节,则long类型数据占__个字节, short类型数据占__个字节.",
"int x=2;z=++x+1; 则z的值为__.",
"当a=1,b=2,c=3时,执行以下程序段后c=___. \nif (a>c)  b=a;  a=c;  c=b;",
"一个C源程序中至少应包括一个__函数.",
"执行下列语句的结果是__,a=3;printf('%d,',++a);printf('%d',a++);",
"若有以下数组a,数组元素:a[0]~a[9],其值为  9  4  12  8  2  10  7  5  1  3 该数组可用的最大下标值是__",
"int x=2,y=3,z=4; 则表达式!(x+y)>z的值为__.",
"已知 i=5, 写出语句 a=(i>5)?0:1; 执行后整型变量 a 的值是__.",
"已知a=12,写出表达式 (0<a)&&(a<2) 的值是__.",
"已知 i=5;写出语句 a=--i; 执行后整型变量 a 的值是__",
"已知a=13,b=6,  a||b的十进制数值为__",
"int x=y=4,z=2;x=y==z; 则x的值为__.",
"若有以下数组a,数组元素:a[0]~a[9],其值为  9  4  12  8  2  10  7  5  1  3\n该数组中下标最小的元素名字是__.",
"int x=4,y=z=2;x=x==(y=z); 则x的值为__.",
"若 char w,int x,float y,double z;则表达式w*x+z-y的结果为__类型",
"表达式 i++ 相当于表达式i=__.",
"在C语言中,最小整型数是__.",
"C语言源程序文件的后缀是.C，经过编译之后，生成后缀为.OBJ的__文件，经连接生成后缀.EXE的可执行文件。",
"已知 i=5.6;写出语句 a=(int)i; 执行后变量 i 的值是__.",
"已知a=13,b=6,  a&&b的十进制数值为__.",
"表达式!10 的值是__.(填数字)",
"函数的定义不可以嵌套,但函数的调用__嵌套.",
"若有以下数组a,数组元素:a[0]~a[9],其值为  9  4  12  8  2  10  7  5  1  3\n该数组中下标最大的元素的值是__.",
"执行语句char s[3]='ab',*p;p=3;*(p+2)的值是__.",
"若有以下数组a,数组元素:a[0]~a[9],其值为  9  4  12  8  2  10  7  5  1  3 该数组可用的最小下标值是\n已知 a=10,b=15,c=1,d=2,e=0,则表达式(c==b)>e的值为__.",
"已知 a=10,b=15,c=1,d=2,e=0,则表达式(c==b)>e的值为___",
"C语言中一个函数由函数首部和__两部分组成.",
"将函数funl 的入口地址赋给指针变量p的语句是__.",
"int x=2,y=3,z=4; 则表达式x+y>!z的值为__.",
"unsigned int定义无符号基本整型 变量，分配__个字节的存储单元。",
"C语言中,数组名是一个不可变的__量,不能对它进行加减和赋值运算.",
"若有定义:int a=10,b=9,c=8;接着顺序执行下列语句后,变量b中的值是__ .\nc=(a-=(b-5)); c=(a%11)+(b=3);",
"int x=y=z=2;x=y==z; 则x的值为__",
"已知a=13,b=6,  !a的十进制数值为__.",
"int x=2,y=3,z=4; 则表达式x+y>z的值为__.",
"在C语言中的实型变量分为两种类型,它们是float型和__型",
"已知a=13, a<<2的十进制数值为__.",
"静态变量和外部变量的初始化是在___阶段完成的,而自动变量的赋值是 在__时进行的",
"c语言表达式5>2>7>8的值是__.",
"表达式 a+=b 相当于表达式__.",
"若有以下数组a,数组元素:a[0]~a[9],其值为  9  4  12  8  2  10  7  5  1  3\n该数组的元素中,数值最大的元素的下标值是__.",
"写出语句 b=(a=6,a*3); 执行后整型变量b的值是__.",
"设(k=a=5,b=3,a*b),则k值为__.",
"int x=2,y=3,z=4; 则表达式x+y>z&&y==z的值为__",
"调用 fopen 函数打开一文本文件,在'使用方式'这一项中, 为输出而打开需填入__.",
"int x=4,y=z=2;z=x==(y=z); 则z的值为__.",
"已知a=13,b=6,  a/b的十进制数值为__.",
"设变量定义为'int x=3, *p=&x;',设变量x的地址为2000,则*p=__,&(*p)=__(填数字)",
"函数调用时的实参和形参之间的数据是单向的__传递.",
"若有以下数组a,数组元素:a[0]~a[9],其值为  9  4  12  8  2  10  7  5  1  3 该数组中下标最大的元素的值是__.",
"已知a=13,b=6,a/b的十进制数值为__.",
"已知a=13,b=6,  a|b的十进制数值为___.",
"在c语言中,格式输入操作是由库函数在C语言中,格式输入操作是由库函数___完成的,格式输出操作是由库函数___完成的.",
"若int x=6;则x+=x-=x*x表达式最后x的值是__",
"调用 fopen 函数打开一文本文件,在'使用方式'这一项中, 为追加而打开需填入___.",
"若a,b和c均是int型变量,则计算表达式 a=(b=4)+(c=2) 后,a值为___, b值为___,c值为___",
"已知 a=10,b=15,c=1,d=2,e=0,则表达式c==b>e的值为___.",
"当a=1,b=2,c=3时,执行以下程序段后b=___.\nif (a>c) \nb=a;    a=c;    c=b;",
"在C语言中,文件的存取是以___为单位的,这种文件被称为___文件.",
"C语言中调用___函数来关闭文件.",
"下列语句输出的结果是___,int a=-1;printf('%x',a);",
"设a,b,t 为整型变量,初值为a=7,b=9,执行完语句t=(a>b)?a:b后,t 的值是___.",
"已知 a=10,b=15,c=1,d=2,e=0,则表达式 a+b>10||a+b<0的值为___.",
"设x=2.5,a=7,y=4.7,算术表达式x+a%3*(int)(x+y)%2/4的值为___",
"假设有条件 int x=1,y=2,z=3;则表达式z+=x>y?++x:++y的值是___",
"int a=1,b=2,c=3;  执行语句a += b *= c;后a的值是___",
"x=5,y=8时,c语言表达式5-2>=x-1<=y-2的值是___",
"以下do-while语句中循环体的执行次数是___.\na=10;      b=0;\ndo { b+=2; a-=2+b; } while (a>=0);", 
"设 int x=1/4;则x的值为___.",
"在c程序中,可以通过三种运算方式为指针变量赋地址值,它们是___,=,malloc.",
"为了避免嵌套条件语句的二义性,C语言规定else与其前面最近的___语句配对.",
"调用 fopen 函数打开一文本文件,在'使用方式'这一项中, 为输入而打开需填入___.",
"若有定义:char s[ ]='china'; 则Turbo C系统为数组s开辟___个字节的内存单元.",
"如果函数不要求带回值,可用___来定义函数返回值为空.",
"设i,j,k均为int型变量,则执行完下面的for循环后,k的值为___.\nfor(i=0,j=10;i<=j;i++,j--) k=i+j;",
"int x=2,y=2,z=0; 则表达式x==y>z的值为___",};
	public static String da[]={"0","3","30","0","30","3","15","1","位 ","9 10","字符" ,"9","行","2","a[0]","-1","10 6","0","strlen","#","1","1",
		"2","1","4 2","4","2","main","4 4","9","0","1","0","4","1","0","a[0]","0","double","i+1", "-32768","目标","5.6","1","0","可以","3","\0'",
		"0","0","函数体","p=funl;","1","2","地址","3","1","0","1","double","52","编译 函数调用","0","a=a+b", "2","18","5","0","w","0","2","3 2000","值",
		"3","2","15","scanf printf","-60","a","6 4 2","1","2","字符  流式","fclose()","ffff","9","1","2.5","6","7","1","3","0","&","if","r", "6","void","10","0"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1=(TextView)findViewById(R.id.main_tv1);
		bt1=(Button)findViewById(R.id.main_bt1);
	    insert();
	
	
		bt1.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,choosePage.class);
				startActivity(intent);
			}
		
		});
	
		
	}
	public void insert()
	{
		application = (MyApplication) getApplication();
		SQLiteDatabase db = application.getDB();
		ContentValues values = new ContentValues();
		for(int i=0;i<100;i++)
		{
			values.put("id", i);
			values.put("answer", b[i]);
			values.put("question", a[i]);
			db.insert("channels", null, values);
		}
		ContentValues values2 = new ContentValues();
		for(int j=100;j<200;j++)
		{
			values2.put("id", j);
			values2.put("answer", da[j-100]);
			values2.put("question", ti[j-100]);
			db.insert("channels", null, values2);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
