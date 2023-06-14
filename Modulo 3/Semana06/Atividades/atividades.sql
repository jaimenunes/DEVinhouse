-- ex 01---

CREATE TABLE PRODUTO(
 ID  NUMBER PRIMARY KEY,
 DESCRICAO VARCHAR2(50) NOT NULL,
 STATUS NUMBER(1) NOT NULL,
 CADASTRO TIMESTAMP NOT NULL,
 QUANTIDADE_ESTOQUE NUMBER NOT NULL
);

INSERT INTO PRODUTO (ID, DESCRICAO, STATUS, CADASTRO, QUANTIDADE_ESTOQUE) VALUES (1, 'Notebook Dell', 1, TO_DATE('2023-06-06 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 10);
INSERT INTO PRODUTO (ID, DESCRICAO, STATUS, CADASTRO, QUANTIDADE_ESTOQUE) VALUES (2, 'Smartphone Samsung', 1, TO_DATE('2023-06-06 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), 15);
INSERT INTO PRODUTO (ID, DESCRICAO, STATUS, CADASTRO, QUANTIDADE_ESTOQUE) VALUES (3, 'Headset Bluetooth', 0, TO_DATE('2023-06-06 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), 5);
INSERT INTO PRODUTO (ID, DESCRICAO, STATUS, CADASTRO, QUANTIDADE_ESTOQUE) VALUES (4, 'Monitor LG', 1, TO_DATE('2023-06-06 13:00:00', 'YYYY-MM-DD HH24:MI:SS'), 20);
INSERT INTO PRODUTO (ID, DESCRICAO, STATUS, CADASTRO, QUANTIDADE_ESTOQUE) VALUES (5, 'Impressora HP', 0, TO_DATE('2023-06-06 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), 8);
INSERT INTO PRODUTO (ID, DESCRICAO, STATUS, CADASTRO, QUANTIDADE_ESTOQUE) VALUES (6, 'Teclado Mecânico', 1, TO_DATE('2023-06-06 15:00:00', 'YYYY-MM-DD HH24:MI:SS'), 12);
INSERT INTO PRODUTO (ID, DESCRICAO, STATUS, CADASTRO, QUANTIDADE_ESTOQUE) VALUES (7, 'Mouse Logitech', 1, TO_DATE('2023-06-06 16:00:00', 'YYYY-MM-DD HH24:MI:SS'), 18);
INSERT INTO PRODUTO (ID, DESCRICAO, STATUS, CADASTRO, QUANTIDADE_ESTOQUE) VALUES (8, 'Câmera GoPro', 0, TO_DATE('2023-06-06 17:00:00', 'YYYY-MM-DD HH24:MI:SS'), 3);
INSERT INTO PRODUTO (ID, DESCRICAO, STATUS, CADASTRO, QUANTIDADE_ESTOQUE) VALUES (9, 'Roteador TP-Link', 1, TO_DATE('2023-06-06 18:00:00', 'YYYY-MM-DD HH24:MI:SS'), 25);
INSERT INTO PRODUTO (ID, DESCRICAO, STATUS, CADASTRO, QUANTIDADE_ESTOQUE) VALUES (10, 'Caixa de Som Bluetooth', 0, TO_DATE('2023-06-06 19:00:00', 'YYYY-MM-DD HH24:MI:SS'), 7);

COMMIT;

-- ex 02 --

CREATE TABLE produtoPreco(
     ID  NUMBER PRIMARY KEY,
     IDPRODUTO NUMBER NOT NULL,
     VALOR NUMBER(10,2) NOT NULL,
     STATUS NUMBER(1) NOT NULL,
     CADASTRO TIMESTAMP NOT NULL,
     FOREIGN KEY (IDProduto) REFERENCES Produto(ID)
 );
 
 
INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (1, 1, 10.99, 1, TO_DATE('2023-06-07 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (2, 2, 15.50, 0, TO_DATE('2023-06-07 11:30:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (3, 3, 5.99, 1, TO_DATE('2023-06-07 12:45:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (4, 4, 8.75, 1, TO_DATE('2023-06-07 14:15:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (5, 5, 12.99, 0, TO_DATE('2023-06-07 15:30:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (6, 6, 9.99, 1, TO_DATE('2023-06-07 16:45:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (7, 7, 7.50, 0, TO_DATE('2023-06-07 18:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (8, 8, 14.99, 1, TO_DATE('2023-06-07 19:15:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (9, 9, 6.25, 1, TO_DATE('2023-06-07 20:30:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (10, 10, 11.49, 0, TO_DATE('2023-06-07 21:45:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (11, 1, 8.99, 1, TO_DATE('2023-06-07 23:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (12, 2, 13.75, 1, TO_DATE('2023-06-08 00:15:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (13, 3, 9.50, 0, TO_DATE('2023-06-08 01:30:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (14, 4, 17.99, 1, TO_DATE('2023-06-08 02:45:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO ProdutoPreco (ID, IDProduto, Valor, Status, Cadastro)
VALUES (15, 5, 7.25, 1, TO_DATE('2023-06-08 04:00:00', 'YYYY-MM-DD HH24:MI:SS'));

commit;

-- ex 03--

select P.ID as "ID produto",PP.ID as "ID preco produto", P.Descricao, PP.valor, TO_CHAR(PP.cadastro, 'mm/yyyy') as "data cadastro"  from PRODUTO P inner join PRODUTOPRECO PP on P.id = PP.id;


-- ex 04 --

select SUM(valor) as "soma", 
case
    when SUM(valor) < 150.00 then 'soma menor que 150.00'
    when SUM(valor) < 500.00 then 'soma menor que 500.00'
    else 'soma maior que 500.00'
end as "texto soma"
from produtopreco;

-- ex 05 --

select P.*, pp.* from produto p LEFT JOIN produtopreco pp on p.id = pp.id where pp.id is null;

-- ex 06 --

begin
    for i in 1..3 loop
        update produtoPreco
        set valor = valor + (valor * 0.15)
        where valor > 100;
    end loop;
end;

-- ex 07 --

DECLARE
    v_status VARCHAR2(10);
BEGIN
    FOR p IN (SELECT id, status from produto) LOOP
        IF P.status = 1 THEN
            v_status := 'ativo';
        ELSE
            v_status := 'inativo';
        END IF;
        dbms_output.put_line('ID: ' || p.id || ', status: ' || v_status);
    END LOOP;
END;