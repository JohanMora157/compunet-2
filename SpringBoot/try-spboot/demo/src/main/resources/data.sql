-- 1. ROLES
INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('ENTRENADOR');
INSERT INTO roles (name) VALUES ('ATLETA');

-- 2. PERMISOS
INSERT INTO permissions (name, description) VALUES ('CREATE_USER', 'Permite crear nuevos usuarios');
INSERT INTO permissions (name, description) VALUES ('DELETE_USER', 'Permite eliminar usuarios');
INSERT INTO permissions (name, description) VALUES ('CREATE_ROUTINE', 'Permite crear nuevas rutinas');
INSERT INTO permissions (name, description) VALUES ('LOG_ACTIVITY', 'Permite registrar actividades fisicas');

-- 3. ROLES Y PERMISOS
INSERT INTO role_permissions (role_id, permission_id) VALUES (1, 1);
INSERT INTO role_permissions (role_id, permission_id) VALUES (1, 2);
INSERT INTO role_permissions (role_id, permission_id) VALUES (1, 3);
INSERT INTO role_permissions (role_id, permission_id) VALUES (2, 3);
INSERT INTO role_permissions (role_id, permission_id) VALUES (3, 4);

-- 4. USUARIOS
INSERT INTO users (name, email, password, role_id, created_at, updated_at) VALUES 
('Carlos Gomez', 'carlos@gym.com', 'pass123', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO users (name, email, password, role_id, created_at, updated_at) VALUES 
('Laura', 'laura@gym.com', 'pass456', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO users (name, email, password, role_id, created_at, updated_at) VALUES 
('Mateo Fitness', 'mateo@gym.com', 'pass789', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 5. EJERCICIOS
INSERT INTO exercises (name, description, type, estimated_calories, estimated_distance_km, estimated_duration_min, icon, created_at) VALUES
('Press de banca', 'Ejercicio compuesto de empuje para pecho y triceps', 'Fuerza', 120.0, 0.0, 15, 'bench_press.png', CURRENT_TIMESTAMP);
INSERT INTO exercises (name, description, type, estimated_calories, estimated_distance_km, estimated_duration_min, icon, created_at) VALUES
('Sentadillas con barra', 'Ejercicio compuesto para piernas y gluteos', 'Fuerza', 180.0, 0.0, 20, 'squat.png', CURRENT_TIMESTAMP);
INSERT INTO exercises (name, description, type, estimated_calories, estimated_distance_km, estimated_duration_min, icon, created_at) VALUES
('Carrera continua', 'Trote a ritmo moderado al aire libre o cinta', 'Cardio', 250.0, 3.5, 25, 'running.png', CURRENT_TIMESTAMP);

-- 6. RUTINAS
INSERT INTO routines (name, description, user_id, created_at, updated_at) VALUES 
('Torso y Pecho Explosivo', 'Rutina enfocada en fuerza de tren superior', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO routines (name, description, user_id, created_at, updated_at) VALUES 
('Pierna y Cardio', 'Dia pesado de pierna y remate aerobico', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 7. EJERCICIOS DE RUTINA
INSERT INTO routine_exercises (routine_id, exercise_id, order_index, target_sets, target_reps, target_weight_kg, target_duration_min, created_at) VALUES
(1, 1, 1, 4, 10, 60.0, 15, CURRENT_TIMESTAMP);
INSERT INTO routine_exercises (routine_id, exercise_id, order_index, target_sets, target_reps, target_weight_kg, target_duration_min, created_at) VALUES
(2, 2, 1, 4, 12, 80.0, 20, CURRENT_TIMESTAMP);
INSERT INTO routine_exercises (routine_id, exercise_id, order_index, target_sets, target_reps, target_weight_kg, target_duration_min, created_at) VALUES
(2, 3, 2, 1, 1, 0.0, 25, CURRENT_TIMESTAMP);

-- 8. REGISTROS DE ACTIVIDAD
INSERT INTO activity_logs (user_id, routine_id, started_at, completed_at, created_at) VALUES
(3, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 9. EJERCICIOS EN REGISTRO DE ACTIVIDAD
INSERT INTO activity_exercises (activity_log_id, routine_exercise_id, actual_sets, actual_reps, actual_weight_kg, actual_duration_min, calories_burned, distance_covered_km, started_at, completed_at) VALUES
(1, 1, 4, 10, 60.0, 15, 125.0, 0.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
