create table category(
category_id integer auto_increment,
category_name varchar(50),
parent_category_id integer,
primary key(category_id)
);

create table product_category(
product_id integer,
category_id integer,
primary key(product_id)
);
    
create table product_info(
product_id integer,
description text,
supplier_id integer,
location_id integer,
quantity integer,
primary key(product_id)
);
        
create table barcode(
barcode_id integer auto_increment,
barcode varchar(70),
product_id integer,
primary key(barcode_id)
);

create table product(
product_id integer auto_increment,
name varchar(50),
price integer,
primary key(product_id)
);
        
create table supplier(
supplier_id integer auto_increment,
name varchar(50),
description text,
primary key(supplier_id)
);
  
create table order(
order_id integer auto_increment,
customer_id integer,
order_date varchar(50),
total_payment integer,
primary key(order_id)
);

create table order_item(
order_item_id integer auto_increment,
order_id integer,
product_id integer,
order_quantity integer,
primary key(order_item_id)
);
create table customer(
customer_id integer auto_increment,
customer_info_id integer,
name varchar(50),
primary key(customer_id));

create table warehouse(
warehouse_id integer auto_increment,
address varchar(70),
primary key(warehouse_id)
);

create table location(
location_id integer auto_increment,
location_name varchar(60),
warehouse_id integer,
primary key(location_id));
	
create table occupancy(
warehouse_id integer,
occupancy_rate integer,
primary key(warehouse_id)
);

create table personal_info(
personal_info_id integer auto_increment,
phone_number varchar(30),
address varchar(50),
age integer,
primary key(personal_info_id)
);

create table account(
customer_id integer,
password varchar(50),
account_authority_id integer,
primary key(customer_id)
);

create table account_authority(
account_authority integer auto_increment,
authority_name varchar(50),
primary key(account_authority)
);

create table shipping(
shipping_id integer auto_increment,
transfer_status_id integer,
destination_id integer,
shipping_date varchar(40),
order_id integer,
primary key(shipping_id)
);

create table place(
place_id integer auto_increment,
place_name varchar(50),
place_info text,
primary key(place_id)
);

create table transfer_status(
status_id integer auto_increment,
status varchar(50),
primary key(status_id)
);

create table shipping_log(
log_id integer auto_increment,
shipping_id integer,
place_id integer,
status_id integer,
time varchar(50),
primary key(log_id)
);
        
create table shipping_requirement(
shipping_id integer,
requirement text,
primary key(shipping_id)
);
        
create table employee(
employee_id integer auto_increment,
name varchar(50),
role_id integer,
department_id integer,
team_id integer,
personal_info integer,
primary key(employee_id)
);
        
create table department(
department_id integer auto_increment,
department_name varchar(50),
primary key(department_id)
);

create table role(
role_id integer auto_increment,
role_name varchar(50),
primary key(role_id)
);

create table team(
team_id integer auto_increment,
department_id integer,
team_name varchar(50),
primary key(team_id)
);

create table salary(
employee_id integer,
salary_amount integer,
primary key(employee_id)
);

create table task(
task_id integer auto_increment,
task_name varchar(50),
task_description text,
start_date varchar(50),
end_date varchar(50),
primary key(task_id)
);

create table resource_allocation(
allocation_id integer auto_increment,
task_id integer,
resource_id integer,
primary key(allocation_id)
);
        
create table task_assignment(
employee_id integer,
task_id integer,
primary key(employee_id)
);
        
create table resource(
resource_id integer auto_increment,
resource_name varchar(50),
quantity integer,
location_id integer,
primary key(resource_id));

create table vehicle(
vehicle_id integer auto_increment,
car_model varchar(50),
employee_id integer,
primary key(vehicle_id)
);


INSERT INTO warehouse (address) VALUES
('강원도 아산시 테헤란로'),
('강원도 괴산군 서초중앙로'),
('강원도 태백시 영동대가'),
('경상북도 태백시 서초대거리'),
('경상북도 평창군 반포대가');

INSERT INTO place (place_name, place_info) VALUES
('배송지 1', '경기도 성남시 분당구 판교역로 235'),
('배송지 2', '부산특별시 해운대구 센텀중앙로 55'),
('배송지 3', '서울특별시 강남구 테헤란로 312'),
('배송지 4', '서울특별시 강남구 테헤란로 313'),
('배송지 5', '서울특별시 강남구 테헤란로 314'),
('배송지 6', '강원도 춘천시 춘천로 1'),
('배송지 7', '강원도 춘천시 춘천로 2');

INSERT INTO product (`name`, price) VALUES
('딸기', 10000),
('사과', 5000),
('바나나', 3000),
('귤', 1000),
('포도', 5000),
('책상', 100000),
('의자', 50000),
('소파', 300000);

INSERT INTO supplier (`name`, description) VALUES
('공급업체 1', '딸기 공급'),
('공급업체 2', '사과 공급'),
('공급업체 3', '바나나 공급'),
('공급업체 4', '포도 공급'),
('공급업체 5', '귤 공급'),
('공급업체 6', '책상 공급'),
('공급업체 7', '의자 공급'),
('공급업체 8', '소파 공급'),
('공급업체 9', '포장지 공급'),
('공급업체 10', '박스 공급'),
('공급업체 11', '테이프 공급'),
('공급업체 12', '라벨 공급'),
('공급업체 13', '바코드 스캐너 공급');

INSERT INTO `role` (role_name) VALUES
('물류 관리자'),
('고객 서비스 담당자'),
('재고 관리자'),
('배송 코디네이터'),
('품질 검사원'),
('배송 담당자');

INSERT INTO department (department_name) VALUES
('물류 관리'),
('고객 서비스'),
('재고 관리'),
('배송 관리'),
('품질 관리'),
('배송 담당');

INSERT INTO transfer_status (`status`) VALUES
('상품 입고'),
('상품 정렬'),
('상품 포장'),
('배송 준비'),
('배송 중'),
('배송 완료');

-- Inserting data into the account_authority table
INSERT INTO account_authority (authority_name) VALUES
('관리자'),
('창고 관리자'),
('배송 담당자'),
('재고 관리자'),
('고객 서비스 담당자');

-- Inserting data into the occupancy table
INSERT INTO occupancy (warehouse_id, occupancy_rate) VALUES
(1, 10),
(2, 15),
(3, 20),
(4, 15),
(5, 40);

-- Inserting data into the location table
INSERT INTO location (location_name, warehouse_id) VALUES
('창고 1 - 위치 1', 1),
('창고 1 - 위치 2', 1),
('창고 1 - 위치 3', 1),
('창고 2 - 위치 1', 2),
('창고 2 - 위치 2', 2),
('창고 2 - 위치 3', 2),
('창고 3 - 위치 1', 3),
('창고 3 - 위치 2', 3),
('창고 3 - 위치 3', 3),
('창고 4 - 위치 1', 4),
('창고 4 - 위치 2', 4),
('창고 4 - 위치 3', 4),
('창고 5 - 위치 1', 5),
('창고 5 - 위치 2', 5),
('창고 5 - 위치 3', 5);

-- Inserting data into the category table
INSERT INTO category (category_name, parent_category_id) VALUES
('전자제품', NULL),
('스마트폰', 1),
('노트북', 1),
('가전', 1),
('가구', NULL),
('책상', 5),
('의자', 5),
('소파', 5),
('과일', NULL),
('딸기', 9),
('사과', 9),
('바나나', 9),
('귤', 9),
('포도', 9);

-- Inserting data into the product_category table
INSERT INTO product_category (product_id, category_id) VALUES
(1, 10),  
(2, 11),  
(3, 12),  
(4, 13),  
(5, 14),
(6, 6),
(7, 7),
(8, 8);

-- Inserting data into the product_info table
INSERT INTO product_info (product_id, `description`, supplier_id, location_id, quantity) VALUES
(1, '곰곰 딸기', 1, 1, 59),
(2, '문경 사과', 2, 4, 30),
(3, '국산 바나나', 3, 7, 60),
(4, '제주 귤', 4, 11, 10),
(5, '문경 포도', 5, 15, 86),
(6, '책상', 6, 2, 20),
(7, '의자', 7, 5, 30),
(8, '소파', 8, 8, 40);

-- Inserting data into the barcode table
INSERT INTO barcode (barcode, product_id) VALUES
('5901234123457', 1),
('5901234123458', 2),
('5901234123459', 3),
('5901234123460', 4),
('5901234123461', 5),
('5901234123462', 6),
('5901234123463', 7),
('5901234123464', 8);

-- Inserting data into the team table
INSERT INTO team (department_id, team_name) VALUES
(1, '물류 1팀'),
(2, '고객 1팀'),
(3, '재고 1팀'),
(4, '배송 1팀'),
(5, '품질 1팀'),
(6, '배송 2팀');

-- Inserting data into the personal_info table
INSERT INTO personal_info (phone_number, address, age) VALUES
('041-470-7705', '세종특별자치시 동대문구 압구정가', 50),
('052-556-5876', '대전광역시 금천구 학동9거리 (경희권김면)', 50),
('018-431-3678', '대구광역시 강북구 석촌호수거리 (지민김리)', 46),
('055-584-7500', '경상남도 의정부시 테헤란931거리 (선영김김읍)', 40),
('062-246-9906', '대전광역시 서구 선릉로', 62),
('031-136-6933', '전라남도 평택시 봉은사738길 (준영최이리)', 41),
('041-184-7769', '경상남도 원주시 도산대로 (준영조리)', 41),
('017-337-4169', '전라북도 홍천군 영동대로', 70),
('051-116-7482', '충청북도 양구군 잠실가', 18),
('041-357-3931', '부산광역시 중구 삼성가 (미정이읍)', 66),
('018-222-6684', '대구광역시 강남구 언주로', 33),
('054-767-3796', '제주특별자치도 태안군 서초대가 (영미윤동)', 67),
('061-097-8193', '충청남도 괴산군 압구정로', 61),
('016-724-6905', '전라남도 부천시 소사구 압구정9로 (명자김송동)', 59),
('016-266-3263', '대구광역시 서초구 선릉로', 35),
('051-336-0221', '대구광역시 강서구 서초대41가', 50),
('052-519-8613', '제주특별자치도 영동군 도산대467거리', 46),
('041-011-3339', '광주광역시 성북구 석촌호수길', 30),
('052-238-9157', '서울특별시 종로구 학동대로', 29),
('041-594-5701', '전라북도 은평구 서초로', 56),
('031-488-2081', '경상남도 영덕군 학동대로', 33);

-- customer 테이블 데이터 삽입
INSERT INTO customer (`name`, customer_info_id) VALUES
('전민준', 1),
('최예원', 2),
('김서준', 3),
('김서윤', 4),
('김서현', 5),
('류상현', 6),
('우선영', 7),
('김재현', 8),
('김미정', 9),
('이명자', 10),
('박지훈', 11),
('권영희', 12),
('김성수', 13),
('장준호', 14),
('박보람', 15);

-- Inserting data into the employee table
INSERT INTO employee (`name`, role_id, department_id, team_id, personal_info) VALUES
('박혜진', 1, 1, 1, 16),
('김수진', 2, 2, 2, 17),
('김민지', 3, 3, 3, 18),
('박민지', 4, 4, 4, 19),
('오지민', 5, 5, 5, 20),
('박상호', 3, 4, 4, 21),
('유정남', 2, 4, 3, 22),
('이예지', 5, 5, 5, 23),
('김재호', 2, 4, 1, 24),
('김호호', 2, 4, 1, 25),
('박현숙', 1, 3, 5, 26),
('박종수', 4, 2, 2, 27),
('하예원', 1, 5, 1, 28),
('이정희', 3, 2, 3, 29),
('한민지', 2, 1, 3, 30);

-- order_table 테이블 데이터 삽입
INSERT INTO `order` (customer_id, order_date, total_payment) VALUES
(2, '2023-08-04', 6410),
(2, '2023-09-21', 7211),
(4, '2023-07-17', 6353),
(2, '2023-08-16', 5303),
(1, '2023-05-14', 4195),
(13, '2023-08-04', 6410),
(3, '2023-09-21', 7211),
(15, '2023-07-17', 6353),
(13, '2023-08-16', 5303),
(1, '2023-05-14', 4195),
(14, '2023-08-04', 6410),
(4, '2023-09-21', 7211),
(11, '2023-07-17', 6353),
(9, '2023-08-16', 5303),
(8, '2023-05-14', 4195);

-- order_item 테이블 데이터 삽입
INSERT INTO order_item (order_id, product_id, order_quantity) VALUES
(1, 3, 5),
(2, 2, 4),
(3, 4, 3),
(4, 3, 7),
(5, 4, 1),
(6, 3, 5),
(7, 2, 4),
(8, 4, 3),
(9, 3, 7),
(10, 4, 1),
(11, 3, 5),
(12, 2, 4),
(13, 4, 3),
(14, 3, 7),
(15, 4, 1);

INSERT INTO account (customer_id, password, account_authority_id) VALUES
(1, '@2Dge4_r)(', 5),
(2, 'mi1lXrvU*q', 2),
(3, '&1E98IJtx$', 5),
(4, 'jBUHbYKf$8', 2),
(5, '^$*Qh+uz63', 2);

INSERT INTO shipping (transfer_status_id, destination_id, shipping_date, order_id) VALUES
(5, 2, '2023-08-22', 3),
(3, 4, '2023-09-03', 3),
(3, 7, '2023-06-29', 4),
(6, 1, '2023-08-20', 1),
(3, 5, '2023-09-14', 1),
(4, 3, '2023-07-30', 2),
(6, 6, '2023-08-22', 2),
(3, 2, '2023-09-03', 3),
(3, 4, '2023-06-29', 3),
(6, 7, '2023-08-20', 4),
(3, 1, '2023-09-14', 4),
(4, 5, '2023-07-30', 5),
(6, 3, '2023-08-22', 5),
(3, 6, '2023-09-03', 6),
(3, 2, '2023-06-29', 6),
(6, 4, '2023-08-20', 7),
(3, 7, '2023-09-14', 7),
(4, 1, '2023-07-30', 8),
(6, 5, '2023-08-22', 8),
(3, 3, '2023-09-03', 9),
(3, 6, '2023-06-29', 9),
(6, 2, '2023-08-20', 10),
(3, 4, '2023-09-14', 10),
(4, 7, '2023-07-30', 11),
(6, 1, '2023-08-22', 11),
(3, 5, '2023-09-03', 12),
(3, 3, '2023-06-29', 12),
(6, 6, '2023-08-20', 13),
(3, 2, '2023-09-14', 13),
(4, 4, '2023-07-30', 14);

INSERT INTO shipping_log (shipping_id, place_id, status_id, time) VALUES
(5, 2, 5, '2023-07-03 02:33:45'),
(1, 7, 3, '2023-03-07 12:20:50'),
(3, 5, 6, '2023-09-29 15:07:01'),
(2, 1, 6, '2023-11-14 15:03:44'),
(4, 3, 4, '2023-06-20 22:16:53'),
(5, 6, 3, '2023-07-03 02:33:45'),
(6, 2, 5, '2023-03-07 12:20:50'),
(7, 4, 3, '2023-09-29 15:07:01'),
(8, 7, 6, '2023-11-14 15:03:44'),
(9, 1, 6, '2023-06-20 22:16:53'),
(10, 5, 4, '2023-07-03 02:33:45'),
(11, 3, 3, '2023-03-07 12:20:50'),
(12, 6, 5, '2023-09-29 15:07:01'),
(13, 2, 6, '2023-11-14 15:03:44'),
(14, 4, 3, '2023-06-20 22:16:53'),
(15, 7, 6, '2023-07-03 02:33:45'),
(16, 1, 5, '2023-03-07 12:20:50'),
(17, 5, 3, '2023-09-29 15:07:01'),
(18, 7, 6, '2023-11-14 15:03:44'),
(19, 2, 6, '2023-06-20 22:16:53'),
(20, 4, 4, '2023-07-03 02:33:45'),
(21, 6, 3, '2023-03-07 12:20:50'),
(22, 2, 5, '2023-09-29 15:07:01'),
(23, 4, 3, '2023-11-14 15:03:44');

-- shipping_requirement 테이블 데이터 삽입
INSERT INTO shipping_requirement (shipping_id, requirement) VALUES
(1, '긴급 배송 요망.'),
(2, '온도 조절 필요.'),
(3, '부서지기 쉬운 물품 주의.'),
(4, '지정된 시간에 배송 요청.'),
(5, '배송 시 보안 강화 요망.');

-- resource 테이블 데이터 삽입
INSERT INTO resource (resource_name, quantity, location_id) VALUES
('포장지', 28, 2),
('박스', 18, 15),
('테이프', 98, 2),
('라벨', 84, 6),
('바코드 스캐너', 31, 7),
('포장지', 28, 2),
('박스', 18, 15),
('테이프', 98, 2),
('라벨', 84, 6),
('바코드 스캐너', 31, 7);

-- task 테이블 데이터 삽입
INSERT INTO task (task_name, task_description, start_date, end_date) VALUES
('재고 정리', '창고 내 재고 정리 및 관리 작업.', '2023-08-08', '2023-06-13'),
('고객 응대', '고객 서비스 향상을 위한 트레이닝.', '2023-07-25', '2023-12-04'),
('배송 준비', '배송 물품 포장 및 준비 작업.', '2023-08-09', '2023-12-04'),
('품질 검사', '제품 품질 검사 및 보고.', '2023-06-30', '2023-10-09'),
('배송 관리', '배송 스케줄 관리 및 최적화.', '2023-03-17', '2023-03-27'),
('재고 관리', '재고 관리 및 보고.', '2023-07-25', '2023-12-04'),
('물류 관리', '물류 관리 및 보고.', '2023-08-09', '2023-12-04'),
('품질 관리', '품질 관리 및 보고.', '2023-06-30', '2023-10-09');

-- resource_allocation 테이블 데이터 삽입
INSERT INTO resource_allocation (task_id, resource_id) VALUES
(3, 2),
(3, 1),
(2, 3),
(4, 5),
(4, 3),
(4, 4),
(5, 5),
(5, 3),
(5, 4),
(6, 5),
(6, 3),
(6, 4),
(7, 5),
(7, 3),
(7, 4),
(8, 5),
(8, 3),
(8, 4);

-- task_assignment 테이블 데이터 삽입
INSERT INTO task_assignment (employee_id, task_id) VALUES
(1, 3),
(2, 1),
(3, 2),
(4, 1),
(5, 2),
(6, 3),
(7, 4),
(8, 5),
(9, 6),
(10, 7),
(11, 8),
(12, 3),
(13, 4),
(14, 5),
(15, 6);

INSERT INTO vehicle (car_model, employee_id) VALUES
('현대 쏘나타', 1),
('기아 스포티지', 2),
('쉐보레 스파크', 3),
('현대 그랜저', 4),
('기아 K5', 5),
('쉐보레 말리부', 6),
('현대 쏘나타', 7),
('기아 스포티지', 8),
('쉐보레 스파크', 9),
('현대 그랜저', 10),
('기아 K5', 11),
('쉐보레 말리부', 12),
('현대 쏘나타', 13),
('기아 스포티지', 14),
('쉐보레 스파크', 15);

-- salary 테이블 데이터 삽입
INSERT INTO salary (employee_id, salary_amount) VALUES
(1, 3000000),
(2, 3500000),
(3, 2500000),
(4, 4000000),
(5, 2800000),
(6, 3000000),
(7, 3500000),
(8, 2500000),
(9, 4000000),
(10, 2800000),
(11, 3000000),
(12, 3500000),
(13, 2500000),
(14, 4000000),
(15, 2800000);