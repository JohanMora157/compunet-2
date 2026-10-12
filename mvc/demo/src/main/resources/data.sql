-- =============================================
-- ROLES (2 registros)
-- =============================================
INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'USER');

-- =============================================
-- PERMISOS (5 registros)
-- =============================================
INSERT INTO permissions (id, name, description) VALUES (1, 'USER_READ', 'Permiso para consultar usuarios');
INSERT INTO permissions (id, name, description) VALUES (2, 'USER_WRITE', 'Permiso para crear y editar usuarios');
INSERT INTO permissions (id, name, description) VALUES (3, 'ROUTINE_READ', 'Permiso para ver rutinas');
INSERT INTO permissions (id, name, description) VALUES (4, 'ROUTINE_WRITE', 'Permiso para gestionar rutinas');
INSERT INTO permissions (id, name, description) VALUES (5, 'ACTIVITY_LOG', 'Permiso para registrar actividad');

-- =============================================
-- ROLE_PERMISSIONS
-- =============================================
INSERT INTO role_permissions (id, role_id, permission_id) VALUES (1, 1, 1);
INSERT INTO role_permissions (id, role_id, permission_id) VALUES (2, 1, 2);
INSERT INTO role_permissions (id, role_id, permission_id) VALUES (3, 1, 3);
INSERT INTO role_permissions (id, role_id, permission_id) VALUES (4, 1, 4);
INSERT INTO role_permissions (id, role_id, permission_id) VALUES (5, 2, 3);
INSERT INTO role_permissions (id, role_id, permission_id) VALUES (6, 2, 5);

-- =============================================
-- USUARIOS (11 registros)
-- =============================================
INSERT INTO users (role_id, name, email, password, created_at, updated_at) 
VALUES (1, 'Carlos Gomez', 'carlos.gomez@example.com', 'admin123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (role_id, name, email, password, created_at, updated_at) 
VALUES (2, 'Laura Perez', 'laura.perez@example.com', 'user123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (role_id, name, email, password, created_at, updated_at) 
VALUES (2, 'Mateo Rios', 'mateo.rios@example.com', 'user456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (role_id, name, email, password, created_at, updated_at) 
VALUES (2, 'Mateo Rios', 'mateo.rios1@example.com', 'user456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (role_id, name, email, password, created_at, updated_at) 
VALUES (2, 'Mateo Rios', 'mateo.rios2@example.com', 'user456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (role_id, name, email, password, created_at, updated_at) 
VALUES (2, 'Mateo Rios', 'mateo.rios3@example.com', 'user456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (role_id, name, email, password, created_at, updated_at) 
VALUES (2, 'Mateo Rios', 'mateo.rios4@example.com', 'user456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (role_id, name, email, password, created_at, updated_at) 
VALUES (2, 'Mateo Rios', 'mateo.rios5@example.com', 'user456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (role_id, name, email, password, created_at, updated_at) 
VALUES (2, 'Mateo Rios', 'mateo.rios6@example.com', 'user456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (role_id, name, email, password, created_at, updated_at) 
VALUES (2, 'Mateo Rios', 'mateo.rios7@example.com', 'user456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (role_id, name, email, password, created_at, updated_at) 
VALUES (2, 'Mateo Rios', 'mateo.rios8@example.com', 'user456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- =============================================
-- EJERCICIOS (3 registros)
-- =============================================
INSERT INTO exercises (id, name, description, type, estimated_calories, estimated_distance_km, estimated_duration_min, icon, created_at) 
VALUES (1, 'Sentadillas', 'Sentadilla libre con barra para tren inferior', 'Fuerza', 120.0, 0.0, 15, 'squat_icon', CURRENT_TIMESTAMP);

INSERT INTO exercises (id, name, description, type, estimated_calories, estimated_distance_km, estimated_duration_min, icon, created_at) 
VALUES (2, 'Trote en Cinta', 'Carrera continua a velocidad constante', 'Cardio', 280.0, 5.0, 30, 'run_icon', CURRENT_TIMESTAMP);

INSERT INTO exercises (id, name, description, type, estimated_calories, estimated_distance_km, estimated_duration_min, icon, created_at) 
VALUES (3, 'Press de Banca', 'Press plano con barra para pectoral y tríceps', 'Fuerza', 150.0, 0.0, 20, 'bench_icon', CURRENT_TIMESTAMP);

-- =============================================
-- RUTINAS (3 registros)
-- =============================================
INSERT INTO routines (id, user_id, name, description, created_at, updated_at) 
VALUES (1, 2, 'Día de Pierna', 'Rutina de hipertrofia para tren inferior', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO routines (id, user_id, name, description, created_at, updated_at) 
VALUES (2, 2, 'Cardio Quema Grasa', 'Sesión aeróbica matutina', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO routines (id, user_id, name, description, created_at, updated_at) 
VALUES (3, 3, 'Torso y Pecho', 'Rutina de fuerza para tren superior', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- =============================================
-- RUTINA_EJERCICIOS (3 registros)
-- =============================================
INSERT INTO routine_exercises (id, routine_id, exercise_id, order_index, target_sets, target_reps, target_weight_kg, target_duration_min, created_at) 
VALUES (1, 1, 1, 1, 4, 12, 50.0, 15, CURRENT_TIMESTAMP);

INSERT INTO routine_exercises (id, routine_id, exercise_id, order_index, target_sets, target_reps, target_weight_kg, target_duration_min, created_at) 
VALUES (2, 2, 2, 1, 1, 1, 0.0, 30, CURRENT_TIMESTAMP);

INSERT INTO routine_exercises (id, routine_id, exercise_id, order_index, target_sets, target_reps, target_weight_kg, target_duration_min, created_at) 
VALUES (3, 3, 3, 1, 4, 10, 60.0, 20, CURRENT_TIMESTAMP);

-- =============================================
-- LOGS DE ACTIVIDAD (3 registros)
-- =============================================
INSERT INTO activity_logs (id, user_id, routine_id, started_at, completed_at, created_at) 
VALUES (1, 2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO activity_logs (id, user_id, routine_id, started_at, completed_at, created_at) 
VALUES (2, 2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO activity_logs (id, user_id, routine_id, started_at, completed_at, created_at) 
VALUES (3, 3, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- =============================================
-- EJERCICIOS DE ACTIVIDAD (3 registros)
-- =============================================
INSERT INTO activity_exercises (id, activity_log_id, routine_exercise_id, actual_sets, actual_reps, actual_weight_kg, actual_duration_min, calories_burned, distance_covered_km, started_at, completed_at) 
VALUES (1, 1, 1, 4, 12, 50.0, 15, 125.0, 0.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO activity_exercises (id, activity_log_id, routine_exercise_id, actual_sets, actual_reps, actual_weight_kg, actual_duration_min, calories_burned, distance_covered_km, started_at, completed_at) 
VALUES (2, 2, 2, 1, 1, 0.0, 30, 275.0, 5.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO activity_exercises (id, activity_log_id, routine_exercise_id, actual_sets, actual_reps, actual_weight_kg, actual_duration_min, calories_burned, distance_covered_km, started_at, completed_at) 
VALUES (3, 3, 3, 4, 10, 60.0, 20, 155.0, 0.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
