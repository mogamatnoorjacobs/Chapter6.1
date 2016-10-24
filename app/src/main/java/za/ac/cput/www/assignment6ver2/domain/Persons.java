package za.ac.cput.www.assignment6ver2.domain;

/**
 * Created by fatimam on 2016-05-22.
 */
public class Persons
{
    private Long id;

    public Long getId() {
        return id;
    }
    private String firstName;
    private String lastName;;
    private String identityNumber;
    private String houseNumber;
    private String road;
    private String area;

    private String uName;
    private String passw;

    public Persons(){}

    public String getName()
    {
        return firstName;
    }

    public String getSurname() {

        return lastName;
    }
    public String getIDNumber() {

        return identityNumber;
    }

    public String getHouseNumber()
    {
        return houseNumber;
    }

    public String getRoad()
    {
        return road;
    }

    public String getArea()
    {
        return area;
    }
    public String getUsername()
    {

        return uName;
    }

    public String getPassword()
    {
        return passw;
    }

    private Persons(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.identityNumber = builder.identityNumber;
        this.houseNumber=builder.houseNumber;
        this.road=builder.road;
        this.area=builder.area;
        this.uName=builder.uName;
        this.passw=builder.passw;

    }

    //***********************************Builder********************************************
    public static class Builder{
        private Long id;
        private String firstName;
        private String lastName;
        private String identityNumber;
        private String houseNumber;
        private String road;
        private String area;

        private String uName;
        private String passw;

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder name(String value){
            this.firstName = value;
            return this;
        }
        public Builder surname(String value){
            this.lastName = value;
            return this;
        }
        public Builder idNumber(String value){
            this.identityNumber= value;
            return this;
        }

        public Builder houseNum(String value)
        {
            this.houseNumber=value;
            return this;
        }
        public Builder roadName(String value)
        {
            this.road=value;
            return this;
        }
        public Builder areaName(String value)
        {
            this.area=value;
            return this;
        }
        public Builder userName(String value){
            this.uName= value;
            return this;
        }

        public Builder passWord(String value){
            this.passw= value;
            return this;
        }


        public Builder copy(Persons value)
        {
            this.id=value.id;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.identityNumber = value.identityNumber;
            this.houseNumber=value.houseNumber;
            this.road=value.road;
            this.area=value.area;
            this.uName=value.uName;
            this.passw=value.passw;
            return this;
        }

        public Persons build()
        {
            return new Persons(this);
        }
    }

}
