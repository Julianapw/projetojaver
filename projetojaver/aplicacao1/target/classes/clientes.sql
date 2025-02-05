INSERT INTO cliente (nome, telefone, correntista, score_credito, saldo_cc) 
VALUES 
    ('Maria Silva', 11987654321, 1, 85.0, 5000.0),
    ('João Santos', 11912345678, 0, 70.0, 2000.0);
ALTER TABLE cliente MODIFY saldo_cc DECIMAL(15,2);

