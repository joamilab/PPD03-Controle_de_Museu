
/**
* GuardaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GuardaIDL.idl
* Domingo, 24 de Abril de 2016 19h35min44s GMT-03:00
*/

public final class GuardaHolder implements org.omg.CORBA.portable.Streamable
{
  public Guarda value = null;

  public GuardaHolder ()
  {
  }

  public GuardaHolder (Guarda initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = GuardaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    GuardaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return GuardaHelper.type ();
  }

}
