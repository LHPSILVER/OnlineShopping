package com.example.onlineshoppingsystem.entities.invoice;

import com.example.onlineshoppingsystem.entities.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "invoice_item")
public class InvoiceItem {
    @EmbeddedId
    private InvoiceItemKey invoiceItemKey;

    @ManyToOne
    @JoinColumn(name = "invoice_id", insertable = false, updatable = false)
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    private Product item;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Embeddable
    public static class InvoiceItemKey implements Serializable {
        @Column(name = "invoice_id")
        private Long invoiceId;

        @Column(name = "product_id")
        private Long productId;
    }
}