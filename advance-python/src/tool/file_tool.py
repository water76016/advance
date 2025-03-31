import os


def remove_blank_lines(file_path, output_path=None):
    """
    读取文件，去除空行，并保存。

    :param file_path: 输入文件路径
    :param output_path: 输出文件路径，如果不指定，则覆盖原文件
    """
    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            lines = file.readlines()

        # 去除空行和只包含空白字符的行
        non_blank_lines = [line for line in lines if line.strip()]

        if output_path is None:
            output_path = file_path

        with open(output_path, 'w', encoding='utf-8') as file:
            file.writelines(non_blank_lines)

        print(f"处理完成: {file_path} -> {output_path}")

    except Exception as e:
        print(f"处理文件 {file_path} 时出错: {e}")


def process_folder(folder_path, backup_folder=None):
    """
    处理文件夹下的所有文件，去除空行。

    :param folder_path: 输入文件夹路径
    :param backup_folder: 备份文件夹路径，如果不指定，则覆盖原文件
    """
    for root, dirs, files in os.walk(folder_path):
        for file_name in files:
            file_path = os.path.join(root, file_name)
            if backup_folder:
                # 生成备份文件的路径
                backup_path = os.path.join(backup_folder, file_name)
                # 确保备份文件夹存在
                os.makedirs(backup_folder, exist_ok=True)
                # 先备份原文件
                with open(file_path, 'r', encoding='utf-8') as file:
                    content = file.read()
                with open(backup_path, 'w', encoding='utf-8') as file:
                    file.write(content)
                print(f"已备份: {file_path} -> {backup_path}")
                # 处理文件，输出到原文件夹（或可以选择输出到另一个文件夹）
                remove_blank_lines(file_path, output_path=file_path)
            else:
                # 直接处理文件，覆盖原文件
                remove_blank_lines(file_path)


if __name__ == "__main__":
    folder_to_process = input("请输入要处理的文件夹路径: ")
    backup = input("是否需要备份文件？(yes/no): ").strip().lower()

    if backup == 'yes':
        backup_folder = input("请输入备份文件夹路径: ")
        process_folder(folder_to_process, backup_folder=backup_folder)
    else:
        process_folder(folder_to_process)