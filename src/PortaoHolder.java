
/**
* PortaoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PortaoIDL.idl
* Domingo, 24 de Abril de 2016 18h52min41s GMT-03:00
*/

public final class PortaoHolder implements org.omg.CORBA.portable.Streamable
{
  public Portao value = null;

  public PortaoHolder ()
  {
  }

  public PortaoHolder (Portao initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PortaoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PortaoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PortaoHelper.type ();
  }

}
