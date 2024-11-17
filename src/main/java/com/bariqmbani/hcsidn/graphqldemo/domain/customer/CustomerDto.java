package com.bariqmbani.hcsidn.graphqldemo.domain.customer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link Customer}
 */
public class CustomerDto implements Serializable {
    private final Long id;
    private final String name;
    private final String email;
    private final String phone;
    private final String address;
    private final LocalDate birthDate;

    public CustomerDto(Long id, String name, String email, String phone, String address, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birthDate = birthDate;
    }

    public CustomerDto(Customer customer) {
        this(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhone(), customer.getAddress(), customer.getBirthDate());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto entity = (CustomerDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.birthDate, entity.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, address, birthDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "email = " + email + ", " +
                "phone = " + phone + ", " +
                "address = " + address + ", " +
                "birthDate = " + birthDate + ")";
    }
}