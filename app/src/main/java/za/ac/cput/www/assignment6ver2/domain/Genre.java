package za.ac.cput.www.assignment6ver2.domain;

/**
 * Created by fatimam on 2016-05-22.
 */
public class Genre
{
    private String genre;

    public Genre() {
    }

    public String getGenre()

    {
        return this.genre;
    }

    private Genre(Builder builder) {
        this.genre = builder.genre;
    }



    //***********************************Builder********************************************
    public static class Builder {
        private String genre;

        public Builder genreType(int value) {
            if (value == 1)
                this.genre = "Action";

            else
                this.genre = "Horror";

            return this;
        }


        public Builder copy(Genre value) {

            this.genre = value.genre;

            return this;
        }

        public Genre build() {
            return new Genre(this);
        }
    }


}