package eryingzhang.net.pojo;

public class ProfessionalCompetition {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column professionalcompetition_.id
     *
     * @mbg.generated Thu Oct 29 15:30:59 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column professionalcompetition_.name
     *
     * @mbg.generated Thu Oct 29 15:30:59 CST 2020
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column professionalcompetition_.id
     *
     * @return the value of professionalcompetition_.id
     *
     * @mbg.generated Thu Oct 29 15:30:59 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column professionalcompetition_.id
     *
     * @param id the value for professionalcompetition_.id
     *
     * @mbg.generated Thu Oct 29 15:30:59 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column professionalcompetition_.name
     *
     * @return the value of professionalcompetition_.name
     *
     * @mbg.generated Thu Oct 29 15:30:59 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column professionalcompetition_.name
     *
     * @param name the value for professionalcompetition_.name
     *
     * @mbg.generated Thu Oct 29 15:30:59 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}