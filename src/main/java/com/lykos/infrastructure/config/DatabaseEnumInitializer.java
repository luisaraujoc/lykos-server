package com.lykos.infrastructure.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseEnumInitializer {

    private final JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void createEnums() {
        try {
            // Criar tipos ENUM no PostgreSQL
            jdbcTemplate.execute("""
                DO $$ 
                BEGIN
                    -- UserType
                    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'user_type') THEN
                        CREATE TYPE user_type AS ENUM ('CLIENTE', 'FREELANCER');
                    END IF;
                    
                    -- AccountStatus
                    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'account_status') THEN
                        CREATE TYPE account_status AS ENUM ('ATIVO', 'INATIVO', 'BANIDO');
                    END IF;
                    
                    -- ProfileStatus
                    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'profile_status') THEN
                        CREATE TYPE profile_status AS ENUM ('ATIVO', 'OCULTO', 'SUSPENSO');
                    END IF;
                    
                    -- Adicione todos os outros ENUMs aqui...
                    -- LanguageLevel
                    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'language_level') THEN
                        CREATE TYPE language_level AS ENUM ('BASICO', 'INTERMEDIARIO', 'AVANCADO', 'FLUENTE');
                    END IF;
                    
                    -- PackageStatus
                    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'package_status') THEN
                        CREATE TYPE package_status AS ENUM ('ATIVO', 'INATIVO');
                    END IF;
                    
                    -- ScheduleStatus
                    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'schedule_status') THEN
                        CREATE TYPE schedule_status AS ENUM ('AGENDADO', 'EM_ANDAMENTO', 'CONCLUIDO', 'CANCELADO', 'REAGENDADO');
                    END IF;
                    
                    -- PaymentStatus
                    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'payment_status') THEN
                        CREATE TYPE payment_status AS ENUM ('PENDENTE', 'PAGO', 'ESTORNADO');
                    END IF;
                    
                    -- AddressType
                    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'address_type') THEN
                        CREATE TYPE address_type AS ENUM ('RESIDENCIAL', 'COMERCIAL');
                    END IF;
                    
                    -- MediaType
                    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'media_type') THEN
                        CREATE TYPE media_type AS ENUM ('IMAGEM', 'VIDEO', 'PDF');
                    END IF;
                    
                    -- ReportStatus
                    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'report_status') THEN
                        CREATE TYPE report_status AS ENUM ('PENDENTE', 'EM_ANALISE', 'RESOLVIDA');
                    END IF;
                END $$;
            """);
            
            System.out.println("✅ Tipos ENUM criados com sucesso no PostgreSQL!");
            
        } catch (Exception e) {
            System.err.println("⚠️ Erro ao criar tipos ENUM: " + e.getMessage());
        }
    }
}