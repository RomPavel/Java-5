class DenominatorExepction extends Exception
{
    String str;
    DenominatorExepction(String str)
    {
        this.str = new String(str);
    }
    public String GetString()
    {
        return this.str;
    }
}
