0、解决Eclipse中无法直接使用Base64Encoder的问题
	Base64的加密解密都是使用sun.misc包下的BASE64Encoder及BASE64Decoder的sun.misc.BASE64Encoder/BASE64Decoder类。
	这个类是sun公司的内部方法，并没有在java api中公开过，不属于JDK标准库范畴，但在JDK中包含了该类，可以直接使用。
	但是在Eclipse和MyEclipse中直接使用,却找不到该类。解决方法如下：
	https://blog.csdn.net/u011514810/article/details/72725398

1、base64是一种编码算法，不算真正的加密和解密算法
	Base64内容传送编码被设计用来把任意序列的8位字节描述为一种不易被人直接识别的形式
	常见于邮件、http加密，截取http信息，你就会发现登录操作的用户名、密码字段通过BASE64加密的。
	编码：sun.misc.BASE64Encoder，将字节数组转换成字符串
	解码：sun.misc.BASE64Decoder，将字符串转换成字节数组
	BASE加密后产生的字节位数是8的倍数，如果不够位数以=符号填充
		YWJjZOWwj+iMl+WQjOWtpu+/pSXigKbigKY=
		YWJjZNCh3PjNrNGno6Qloa2hrQ==

2、MD5：

3、SHA：